package com.stimednp.mvvmwithhilt.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.stimednp.mvvmwithhilt.model.MovieResponse
import com.stimednp.mvvmwithhilt.model.ResultData
import com.stimednp.mvvmwithhilt.usecase.DataUseCase

/**
 * Created by rivaldy on Oct/01/2020.
 * Find me on my lol Github :D -> https://github.com/im-o
 */

class MainViewModel @ViewModelInject constructor(
    private val useCase: DataUseCase
) : ViewModel() {

    fun getMovies(apiKey: String, strLanguage: String): LiveData<ResultData<MovieResponse>> {
        return liveData {
            emit(ResultData.Loading())
            emit(useCase.getMovies(apiKey, strLanguage))
        }
    }
}