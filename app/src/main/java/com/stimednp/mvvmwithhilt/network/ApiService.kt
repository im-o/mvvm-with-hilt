package com.stimednp.mvvmwithhilt.network

import com.stimednp.mvvmwithhilt.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by rivaldy on Oct/01/2020.
 * Find me on my lol Github :D -> https://github.com/im-o
 */

interface ApiService {
    @GET("discover/movie")
    suspend fun getMovies(
        @Query("api_key") apiKey: String,
        @Query("language") strLanguage: String
    ): MovieResponse
}