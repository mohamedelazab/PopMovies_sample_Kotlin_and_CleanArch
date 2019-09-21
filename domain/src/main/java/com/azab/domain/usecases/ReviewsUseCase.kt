package com.azab.domain.usecases

import androidx.lifecycle.MutableLiveData
import com.azab.data.entities.ReviewsResponse
import com.azab.domain.BuildConfig
import com.azab.domain.api.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ReviewsUseCase {

    fun getReviews(movieId: Int): MutableLiveData<ReviewsResponse> {
        val ReviewsResponse = MutableLiveData<ReviewsResponse>()
        ApiClient.getApi().getReviews(movieId, BuildConfig.API_KEY)
            .enqueue(object : Callback<ReviewsResponse> {
                override fun onResponse(
                    call: Call<ReviewsResponse>,
                    response: Response<ReviewsResponse>
                ) {
                    ReviewsResponse.postValue(response.body())
                }

                override fun onFailure(call: Call<ReviewsResponse>, t: Throwable) {
                    ReviewsResponse.postValue(null)
                }
            })
        return ReviewsResponse
    }
}
