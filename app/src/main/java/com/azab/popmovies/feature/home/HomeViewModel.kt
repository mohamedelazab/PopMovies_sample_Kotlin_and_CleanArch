package com.azab.popmovies.feature.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.azab.data.entities.MoviesResponse
import com.azab.domain.repository.MoviesRepository

val repository: MoviesRepository by lazy { MoviesRepository() }

class HomeViewModel : ViewModel() {

    fun getMostPopularMovies(pageNo: Int): MutableLiveData<MoviesResponse> {
        return repository.getMostPopularMovies(pageNo)
    }
}
