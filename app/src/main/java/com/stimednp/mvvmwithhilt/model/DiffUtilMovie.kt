package com.stimednp.mvvmwithhilt.model

import androidx.recyclerview.widget.DiffUtil

/**
 * Created by rivaldy on Oct/02/2020.
 * Find me on my lol Github :D -> https://github.com/im-o
 */

class DiffUtilMovie: DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return newItem.id == oldItem.id
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return newItem.id == oldItem.id
    }
}