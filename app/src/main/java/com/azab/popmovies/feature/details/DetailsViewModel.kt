package com.azab.popmovies.feature.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.azab.data.entities.ReviewsResponse
import com.azab.data.entities.TrailersResponse
import com.azab.domain.repository.ReviewsRepository
import com.azab.domain.repository.TrailersRepository

val reviewsRepository: ReviewsRepository by lazy { ReviewsRepository() }
val trailersRepository: TrailersRepository by lazy { TrailersRepository() }

class DetailsViewModel : ViewModel() {

    fun getTrailer(movieId: Int): MutableLiveData<TrailersResponse> {
        return trailersRepository.getTrailers(movieId)
    }

    fun getReviews(movieId: Int): MutableLiveData<ReviewsResponse> {
        return reviewsRepository.getReviews(movieId)
    }
}
