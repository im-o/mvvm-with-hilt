package com.stimednp.mvvmwithhilt.usecase

import com.stimednp.mvvmwithhilt.model.MovieResponse
import com.stimednp.mvvmwithhilt.model.ResultData
import com.stimednp.mvvmwithhilt.repositories.DataRepository
import javax.inject.Inject

/**
 * Created by rivaldy on Oct/01/2020.
 * Find me on my lol Github :D -> https://github.com/im-o
 */

class DataUseCase @Inject constructor(
    private val dataRepository: DataRepository
) {

    suspend fun getMovies(apiKey: String, strLanguage: String): ResultData<MovieResponse> {
        val movieResponse = dataRepository.getMovies(apiKey, strLanguage)
        return if (movieResponse.page != null) {
            ResultData.Success(movieResponse)
        } else {
            ResultData.Failed("Something went wrong. Please try again!")
        }
    }
}