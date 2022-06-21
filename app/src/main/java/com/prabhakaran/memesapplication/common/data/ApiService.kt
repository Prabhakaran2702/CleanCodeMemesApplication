package com.prabhakaran.memesapplication.common.data

import com.prabhakaran.memesapplication.common.data.model.Data
import com.prabhakaran.memesapplication.common.data.model.Memes
import retrofit2.Response
import retrofit2.http.GET


interface ApiService {

    @GET("get_memes")
    suspend fun getMemes() : Response<Memes>

}