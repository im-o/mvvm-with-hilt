package com.stimednp.mvvmwithhilt.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.stimednp.mvvmwithhilt.BuildConfig
import com.stimednp.mvvmwithhilt.R
import com.stimednp.mvvmwithhilt.model.ResultData
import com.stimednp.mvvmwithhilt.utils.loge
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Just sample, you can set key and language on viewModel
        val listMovie = mainViewModel.getMovies(BuildConfig.API_KEY, "en-US")

        listMovie.observe(this, { resultData ->
            when (resultData) {
                is ResultData.Loading -> {
                    loge("LOADING")
                }
                is ResultData.Success -> {
                    val movies = resultData.data?.results
                    loge("${movies?.size}")
                }
                is ResultData.Failed -> {
                    loge("FAILED : ${resultData.message}")
                }
                is ResultData.Exception -> {
                    loge("EXCEPTION : ${resultData.message}")
                }
            }
        })
    }
}