package com.android.kevinkotlin

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Streaming
import retrofit2.http.Url


/**
 * author : WanKai
 * date : 2024/5/10 17:36
 * description：
 */
interface UpLoadService {

    @Streaming
    @GET
    fun download(@Url url: String?): Call<ResponseBody>
}