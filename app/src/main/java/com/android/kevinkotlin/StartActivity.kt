package com.android.kevinkotlin

import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ijoysoft.event.AppBus
import com.ijoysoft.file.util.ScopeFileUtil
import com.lb.library.ActivityLifecycle
import com.lb.library.MainHandler
import com.squareup.otto.Subscribe
import okhttp3.Call
import okhttp3.Callback
import okhttp3.FormBody
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.Response
import java.io.File
import java.io.IOException

class StartActivity : AppCompatActivity() {

    private var mOkHttpClient: OkHttpClient? = null
    private var mSpeed: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ActivityLifecycle.get().initialize(application)
        AppBus.get().register(this)

        mSpeed = findViewById(R.id.speed)

        println("HelloWord")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            if (!ScopeFileUtil.hasManagerAllFilePermission()) {
                ScopeFileUtil.openScopeManageAllFilePermissionDialog(this, 0)
            }
        }

        findViewById<TextView>(R.id.title).setOnClickListener {
            Toast.makeText(this, "YuKi HaHaHa", Toast.LENGTH_SHORT).show()
        }

        mOkHttpClient = OkHttpClient()

        findViewById<TextView>(R.id.get_sync).setOnClickListener {
            Thread {
                kotlin.run {
                    val build = Request.Builder().url("https://www.httpbin.org/get?a=1&b=2").build()
                    // 准备好的call对象
                    val call = mOkHttpClient?.newCall(build)
                    try {
                        val response = call?.execute()
                        Log.d("wankailog", response?.body?.string() ?: "结果为空")
                    } catch (ignore: IOException) {
                    }
                }
            }.start()
        }

        findViewById<TextView>(R.id.get_async).setOnClickListener {
            val build = Request.Builder().url("https://www.httpbin.org/get?a=1&b=2").build()
            val call = mOkHttpClient?.newCall(build)
            call?.enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {

                }

                override fun onResponse(call: Call, response: Response) {
                    if (response.isSuccessful) {
                        Log.d("wankailog", response.body?.string() ?: "结果为空")
                    }
                }
            })
        }

        findViewById<TextView>(R.id.post_sync).setOnClickListener {

            Thread {
                kotlin.run {
                    val formBody = FormBody.Builder()
                        .add("a", "1").add("b", "2").build()
                    val build = Request.Builder()
                        .url("https://www.httpbin.org/post").post(formBody).build()

                    // 准备好的call对象
                    val call = mOkHttpClient?.newCall(build)
                    try {
                        val response = call?.execute()
                        Log.d("wankailog", response?.body?.string() ?: "结果为空")
                    } catch (ignore: IOException) {
                    }
                }
            }.start()
        }

        findViewById<TextView>(R.id.post_async).setOnClickListener {
            /*
             val formBody = FormBody.Builder()
                 .add("a", "1")
                 .add("b", "2")
                 .build()
             val build = Request.Builder()
                 .url("https://www.httpbin.org/post")
                 .post(formBody)
                 .build()
             val call = mOkHttpClient?.newCall(build)
             call?.enqueue(object : Callback {
                 override fun onFailure(call: Call, e: IOException) {

                 }

                 override fun onResponse(call: Call, response: Response) {
                     if (response.isSuccessful) {
                         Log.d("wankailog", response.body?.string() ?: "结果为空")
                     }
                 }
             })
             */

            // 上传类型
            // https://www.runoob.com/http/http-content-type.html

            val file1 = File(
                Environment.getExternalStorageDirectory().path
                        + "/" + Environment.DIRECTORY_DOWNLOADS + "/111.txt"
            )
            val file2 = File(
                Environment.getExternalStorageDirectory().path
                        + "/" + Environment.DIRECTORY_DOWNLOADS + "/222.txt"
            )
            val multipartBody = MultipartBody.Builder()
                .addFormDataPart(
                    "file1",
                    "111.txt",
                    file1.asRequestBody("text/plain".toMediaTypeOrNull())
                )
                .addFormDataPart(
                    "file2",
                    "222.txt",
                    file2.asRequestBody("text/plain".toMediaTypeOrNull())
                )
                .addFormDataPart("a", "1")
                .build()

            val build = Request.Builder()
                .url("https://www.httpbin.org/post")
                .post(multipartBody)
                .build()
            val call = mOkHttpClient?.newCall(build)
            call?.enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    Log.d("wankailog", e.toString())
                }

                override fun onResponse(call: Call, response: Response) {
                    if (response.isSuccessful) {
                        Log.d("wankailog", response.body?.string() ?: "结果为空")
                    }
                }
            })
        }

        /**
         * [OkHttpUnitTest]
         * [RetrofitUnitTest] [HttpbinService] [WanandroidService]
         * [DownloadTest] [UpLoadService]
         */

        findViewById<TextView>(R.id.run_task).setOnClickListener {
//            OkHttpUnitTest.interceptorTest()
//            OkHttpUnitTest.cacheTest()
//            OkHttpUnitTest.cookieTest()
//            RetrofitUnitTest.test2()
            DownloadTest.downloadTest1()
//            DownloadTest.downloadTest2()
//            DownloadTest.downloadTest3()
        }
    }

    @Subscribe
    fun onEvent(event: SpeedEvent) {
        MainHandler.get().post {
            mSpeed?.text = event.speed
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        AppBus.get().unregister(this)
    }
}