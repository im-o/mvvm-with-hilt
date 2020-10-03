package com.stimednp.mvvmwithhilt.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.stimednp.mvvmwithhilt.databinding.ItemMovieBinding
import com.stimednp.mvvmwithhilt.model.DiffUtilMovie
import com.stimednp.mvvmwithhilt.model.Movie

/**
 * Created by rivaldy on Oct/02/2020.
 * Find me on my lol Github :D -> https://github.com/im-o
 */

class MovieAdapter : ListAdapter<Movie, MovieAdapter.MovieViewHolder>(DiffUtilMovie()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemView = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = getItem(position)
        holder.bindItem(item)
    }

    inner class MovieViewHolder(private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindItem(movie: Movie?) {
            val strUrlImg = "https://image.tmdb.org/t/p/w220_and_h330_face${movie?.posterPath}"
            val strTitle = movie?.originalTitle
            val strDesc = movie?.overview
            val strVote = movie?.voteAverage.toString()

            binding.apply {
                titleTV.text = strTitle
                overviewTV.text = strDesc
                voteTV.text = strVote
                Picasso.get()
                    .load(strUrlImg)
                    .into(posterIV)
            }
        }
    }
}