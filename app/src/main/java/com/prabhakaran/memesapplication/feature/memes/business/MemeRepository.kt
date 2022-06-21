package com.prabhakaran.memesapplication.feature.memes.business

import com.prabhakaran.memesapplication.common.data.model.Data
import com.prabhakaran.memesapplication.common.data.model.Memes
import retrofit2.Response

interface MemeRepository {

    suspend fun getPost() : Response<Memes>

}