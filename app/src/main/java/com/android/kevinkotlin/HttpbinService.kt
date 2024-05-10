package com.android.kevinkotlin

import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * author : WanKai
 * date : 2024/5/10 14:25
 * description：
 */
interface HttpbinService {

    @POST("post")
    @FormUrlEncoded
    fun post(
        @Field("username") userName: String,
        @Field("password") password: String
    ): Call<ResponseBody>

    @GET("get")
    fun get(
        @Query("username") userName: String,
        @Query("password") password: String
    ): Call<ResponseBody>

    @POST("post")
    fun postBody(@Body body: RequestBody): Call<ResponseBody>
}