package com.azab.domain.repository

import androidx.lifecycle.MutableLiveData
import com.azab.data.entities.MoviesResponse
import com.azab.domain.usecases.MoviesUseCase

class MoviesRepository(private val moviesUseCase: MoviesUseCase = MoviesUseCase()) {

    fun getMostPopularMovies(pageNo:Int):MutableLiveData<MoviesResponse> {
        return moviesUseCase.getMostPopularMovies(pageNo)
    }

}
