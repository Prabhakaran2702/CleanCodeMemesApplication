package com.prabhakaran.memesapplication.common.di

import com.prabhakaran.memesapplication.common.Constant.BASE_URL
import com.prabhakaran.memesapplication.common.data.ApiService
import com.prabhakaran.memesapplication.feature.memes.business.MemeRepository
import com.prabhakaran.memesapplication.feature.memes.business.MemeRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@ExperimentalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
class MemeModule {

    @Provides
    @Singleton
    fun providesApiService(): ApiService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)


    @Provides
    fun providesPostRepository(
        service: ApiService
    ): MemeRepository = MemeRepositoryImp(service)


}