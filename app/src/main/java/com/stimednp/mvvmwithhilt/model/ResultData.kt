package com.stimednp.mvvmwithhilt.model

/**
 * Created by rivaldy on Oct/01/2020.
 * Find me on my lol Github :D -> https://github.com/im-o
 */

sealed class ResultData<out T> {
    data class Success<out T>(val data: T? = null): ResultData<T>()
    data class Loading(val nothing: Nothing? = null): ResultData<Nothing>()
    data class Failed(val message: String? = null): ResultData<Nothing>()
    data class Exception(val message: String? = null): ResultData<Nothing>()
}