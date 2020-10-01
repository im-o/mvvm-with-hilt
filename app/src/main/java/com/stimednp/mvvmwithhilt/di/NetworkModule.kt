package com.stimednp.mvvmwithhilt.di

import com.google.gson.GsonBuilder
import com.stimednp.mvvmwithhilt.BuildConfig
import com.stimednp.mvvmwithhilt.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by rivaldy on Oct/01/2020.
 * Find me on my lol Github :D -> https://github.com/im-o
 */

@InstallIn(ApplicationComponent::class)
@Module
object NetworkModule {

    @Provides
    fun providesBaseUrl(): String {
        //return BuildConfig.BASE_URL
        return "https://api.themoviedb.org/3/"
    }

    @Provides
    fun providesLoggingInterceptor(): HttpLoggingInterceptor {
        return if (BuildConfig.DEBUG) HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        else HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE)
    }

    @Provides
    fun providesOkHttpClient(logging: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(logging).build()
    }

    @Provides
    fun providesConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create(GsonBuilder().create())
    }

    @Provides
    fun providesRetrofit(baseUrl: String, converterFactory: GsonConverterFactory, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(converterFactory)
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun providesApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}