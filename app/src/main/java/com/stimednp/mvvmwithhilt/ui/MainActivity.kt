package com.stimednp.mvvmwithhilt.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.stimednp.mvvmwithhilt.BuildConfig
import com.stimednp.mvvmwithhilt.databinding.ActivityMainBinding
import com.stimednp.mvvmwithhilt.model.Movie
import com.stimednp.mvvmwithhilt.model.ResultData
import com.stimednp.mvvmwithhilt.ui.adapter.MovieAdapter
import com.stimednp.mvvmwithhilt.utils.gone
import com.stimednp.mvvmwithhilt.utils.loge
import com.stimednp.mvvmwithhilt.utils.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val mainViewModel by viewModels<MainViewModel>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViewModel()
    }

    private fun initViewModel() {
        //Just sample, you can set key and language on viewModel
        val listMovie = mainViewModel.getMovies(BuildConfig.API_KEY, "en-US")
        listMovie.observe(this, { resultData ->
            when (resultData) {
                is ResultData.Loading -> {
                    binding.loadingPB.visible()
                }
                is ResultData.Success -> {
                    binding.loadingPB.gone()
                    val movies = resultData.data?.results
                    initAdapter(movies)
                }
                is ResultData.Failed -> {
                    binding.loadingPB.gone()
                    loge("FAILED : ${resultData.message}")
                }
                is ResultData.Exception -> {
                    binding.loadingPB.gone()
                    loge("EXCEPTION : ${resultData.message}")
                }
            }
        })
    }

    private fun initAdapter(movies: MutableList<Movie>?) {
        val movieAdapter = MovieAdapter()
        movieAdapter.submitList(movies)
        binding.movieRV.apply {
            setHasFixedSize(true)
            setItemViewCacheSize(movies?.size ?: 0)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = movieAdapter
        }
    }
}