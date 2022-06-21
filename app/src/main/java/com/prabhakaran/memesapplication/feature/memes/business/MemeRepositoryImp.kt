package com.prabhakaran.memesapplication.feature.memes.business

import com.prabhakaran.memesapplication.common.data.ApiService
import com.prabhakaran.memesapplication.common.data.model.Data
import com.prabhakaran.memesapplication.common.data.model.Memes
import retrofit2.Response
import javax.inject.Inject

class MemeRepositoryImp @Inject constructor(private val apiService: ApiService) : MemeRepository {

    override suspend fun getPost(): Response<Memes> = apiService.getMemes()

}