package com.azab.domain.repository

import androidx.lifecycle.MutableLiveData
import com.azab.data.entities.TrailersResponse
import com.azab.domain.usecases.TrailersUseCase

class TrailersRepository(private val trailersUseCase: TrailersUseCase = TrailersUseCase()) {

    fun getTrailers(movieId: Int): MutableLiveData<TrailersResponse> {
        return trailersUseCase.getTrailers(movieId)
    }
}
