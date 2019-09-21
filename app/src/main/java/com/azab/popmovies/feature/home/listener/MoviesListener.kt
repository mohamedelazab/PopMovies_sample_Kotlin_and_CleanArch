package com.azab.popmovies.feature.home.listener

import com.azab.data.entities.Movie

interface MoviesListener {
    fun onMovieItemClicked(movie: Movie)
}
