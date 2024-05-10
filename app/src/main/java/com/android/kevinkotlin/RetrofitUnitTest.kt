package com.android.kevinkotlin

import android.util.Log
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

/**
 * author : WanKai
 * date : 2024/5/10 14:33
 * description：
 */
class RetrofitUnitTest {

    companion object {

        /**
         * 根据http接口创建接口类[HttpbinService]
         *
         * 创建retrofit配置，并生成接口实现类对象
         *
         * 接口实现类对象调用对应方法获得响应
         */
        fun test1() {
            val retrofit = Retrofit.Builder().baseUrl("https://www.httpbin.org/").build()
            val httpbinService = retrofit.create<HttpbinService>()
            val call = httpbinService.get("ijoysoft", "19021902")
//            val formBody = FormBody.Builder().add("a", "1").add("b", "2").build()
//            val call = httpbinService.postBody(formBody)
            call.enqueue(object : Callback<ResponseBody> {
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    if (response.isSuccessful) {
                        Log.d("wankailog", response.body()?.string() ?: "结果为空")
                    }
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    Log.d("wankailog", t.toString())
                }

            })
        }

        /**
         * 方法注解：@GET @POST @PUT @DELETE @HEAD @OPTIONS @HTTP
         * @GET 表示get请求
         * @POST 表示post请求
         * @HTTP 比较通用
         *
         *
         * 标记注解：@FormUrlEncoded @Multipart @Streaming
         * @FormUrlEncoded 配合@Field以表单的形式发送Http请求
         * @Streaming 表示响应体的数据以流的方式返回，适用于返回的数据比较大，常用于下载大文件
         *
         *
         * 参数注解：@Query @QueryMap @Body @Field @FieldMap @Part @PartMap
         * @Query 主要用于Get请求数据，用于拼接在拼接在Url路径后面的查询参数，一个@Query相当于拼接一个参数，多个参数中间用，隔开
         * @Field 类似于@Query，主要不同的是@Field主要用于Post请求数据
         * @Body 表示以json方式请求 多用于post非表单请求
         *
         *
         * 其他注解：@Path @Header @Headers @Uri
         * @Path 主要用于Get请求，用于替换Url路径中的变量字符
         * @Header 设置请求头
         */

        /**
         * Retrofit转换器
         */
        fun test2() {
            val retrofit =
                Retrofit.Builder().baseUrl("https://www.wanandroid.com/")
                    .addConverterFactory(GsonConverterFactory.create()).build()
            val httpbinService = retrofit.create<WanandroidService>()
            val call = httpbinService.post("ijoysoft", "19021902")
            call.enqueue(object : Callback<ResponseBase> {
                override fun onResponse(
                    call: Call<ResponseBase>,
                    response: Response<ResponseBase>
                ) {
                    Log.d("wankailog", response.body().toString())
                }

                override fun onFailure(call: Call<ResponseBase>, t: Throwable) {
                    Log.d("wankailog", t.toString())
                }
            })
        }
    }
}