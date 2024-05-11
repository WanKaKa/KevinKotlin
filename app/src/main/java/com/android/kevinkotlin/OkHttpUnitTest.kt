package com.android.kevinkotlin

import android.util.Log
import com.lb.library.ActivityLifecycle
import okhttp3.Cache
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.FormBody
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.File
import java.io.IOException

/**
 * author : WanKai
 * date : 2024/5/9 17:26
 * description：
 */
class OkHttpUnitTest {
    companion object {

        /**
         * 拦截器
         */
        fun interceptorTest() {
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(Interceptor {
                    val request = it.request().newBuilder()
                        .addHeader("Os", "android")
                        .addHeader("Version", BuildConfig.VERSION_NAME)
                        .build()
                    it.proceed(request)
                })
                // 在addInterceptor之后执行addNetworkInterceptor
                .addNetworkInterceptor(Interceptor {
                    Log.d("wankailog", "Version = " + it.request().header("Version"))
                    it.proceed(it.request())
                })
                .build()
            val build = Request.Builder().url("https://www.httpbin.org/get?a=1&b=2").build()
            val call = okHttpClient.newCall(build)
            call.enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {

                }

                override fun onResponse(call: Call, response: Response) {
                    if (response.isSuccessful) {
                        Log.d("wankailog", response.body?.string() ?: "结果为空")
                    }
                }
            })
        }

        /**
         * 缓存与Cookie
         * OkHttp按照http协议实现了缓存的处理，缓存比如：当我们发起第一次请求后，如果后续还需要进行同样的请求，
         * 此时如果符合缓存规则，则可以减少与服务器的网络通信，直接从本地文件缓存中读取响应返回给请求者。
         * okhttp缓存默认关闭
         */
        fun cacheTest() {
            val okHttpClient = OkHttpClient.Builder()
                .cache(
                    Cache(
                        File(ActivityLifecycle.get().application.filesDir.path + "/OkHttpCache"),
                        10L * 1024L * 1024L
                    )
                )
                .build()
            val build = Request.Builder().url("https://www.httpbin.org/get").build()
            val call = okHttpClient.newCall(build)
            call.enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    Log.e("wankailog", e.toString())
                }

                override fun onResponse(call: Call, response: Response) {
                    if (response.isSuccessful) {
                        Log.d("wankailog", response.body?.string() ?: "结果为空")
                    }
                }
            })
        }

        /**
         * Cookie是某些网站为了辨别用户身份，进行会话跟踪（比如确定登入状态）而储存在用户本地终端上的数据（通常经过加密）
         * 由用户客户端计算机暂时活永久保存的信息
         *
         * 测试网址 https://wanandroid.com/blog/show/2
         */

        val mCookies: HashMap<String, List<Cookie>> = HashMap()

        fun cookieTest() {
            val okHttpClient = OkHttpClient.Builder()
                .cookieJar(object : CookieJar {
                    override fun loadForRequest(url: HttpUrl): List<Cookie> {
                        return mCookies[url.host] ?: ArrayList()
                    }

                    override fun saveFromResponse(url: HttpUrl, cookies: List<Cookie>) {
                        mCookies[url.host] = cookies
                    }
                })
                .build()
            val formBody = FormBody.Builder()
                .add("username", "ijoysoft")
                .add("password", "19021902")
                .build()
            val build = Request.Builder().url("https://www.wanandroid.com/user/login/")
                .post(formBody).build()
            val call = okHttpClient.newCall(build)
            call.enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    Log.e("wankailog", e.toString())
                }

                override fun onResponse(call: Call, response: Response) {
                    if (response.isSuccessful) {
                        Log.d("wankailog", response.body?.string() ?: "结果为空")

                        // 登入成功后请求收藏文章列表
                        val build2 = Request.Builder()
                            .url("https://www.wanandroid.com/lg/collect/list/0/json").build()
                        val call2 = okHttpClient.newCall(build2)
                        call2.enqueue(object : Callback {
                            override fun onFailure(call: Call, e: IOException) {
                                Log.e("wankailog", e.toString())
                            }

                            override fun onResponse(call: Call, response: Response) {
                                Log.d("wankailog", response.body?.string() ?: "结果为空")
                            }
                        })
                    }
                }
            })
        }
    }
}