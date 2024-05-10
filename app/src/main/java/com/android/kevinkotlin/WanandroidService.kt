package com.android.kevinkotlin

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * author : WanKai
 * date : 2024/5/10 14:25
 * description：
 */
interface WanandroidService {

    @POST("user/login")
    @FormUrlEncoded
    fun post(
        @Field("username") userName: String,
        @Field("password") password: String
    ): Call<ResponseBase>
}