package com.stimednp.mvvmwithhilt.repositories

import com.stimednp.mvvmwithhilt.model.MovieResponse
import com.stimednp.mvvmwithhilt.network.ApiService
import javax.inject.Inject

/**
 * Created by rivaldy on Oct/01/2020.
 * Find me on my lol Github :D -> https://github.com/im-o
 */

class DataRepository @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun getMovies(apiKey: String, strLanguage: String): MovieResponse {
        return apiService.getMovies(apiKey, strLanguage)
    }
}