package com.azab.domain.repository

import androidx.lifecycle.MutableLiveData
import com.azab.data.entities.ReviewsResponse
import com.azab.domain.usecases.ReviewsUseCase

class ReviewsRepository(private val reviewsUseCase: ReviewsUseCase = ReviewsUseCase()) {

    fun getReviews(movieId: Int): MutableLiveData<ReviewsResponse> {
        return reviewsUseCase.getReviews(movieId)
    }

}
