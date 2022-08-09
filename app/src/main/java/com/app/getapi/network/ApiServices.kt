package com.app.getapi.network

import com.app.getapi.data.UserItem
import com.app.getapi.data.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiServices {
    @GET("users")
//    @Headers("Authorzation: token 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")
    fun getListUser(): Call<ArrayList<UserItem>>
}