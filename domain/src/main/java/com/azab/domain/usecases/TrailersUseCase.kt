package com.azab.domain.usecases

import androidx.lifecycle.MutableLiveData

import com.azab.data.entities.TrailersResponse
import com.azab.domain.BuildConfig
import com.azab.domain.api.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TrailersUseCase {

    fun getTrailers(movieId: Int): MutableLiveData<TrailersResponse> {
        val trailersResponse = MutableLiveData<TrailersResponse>()
        ApiClient.getApi().getTrailers(movieId, BuildConfig.API_KEY)
            .enqueue(object : Callback<TrailersResponse> {
                override fun onResponse(
                    call: Call<TrailersResponse>,
                    response: Response<TrailersResponse>
                ) {
                    trailersResponse.postValue(response.body())
                }

                override fun onFailure(call: Call<TrailersResponse>, t: Throwable) {
                    trailersResponse.postValue(null)
                }
            })
        return trailersResponse
    }
}
