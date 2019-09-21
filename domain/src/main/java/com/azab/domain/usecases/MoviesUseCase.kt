package com.azab.domain.usecases

import androidx.lifecycle.MutableLiveData

import com.azab.data.entities.MoviesResponse
import com.azab.domain.BuildConfig
import com.azab.domain.api.ApiClient

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesUseCase {

    fun getMostPopularMovies(pageNo: Int): MutableLiveData<MoviesResponse> {
        val mostPopularMovies = MutableLiveData<MoviesResponse>()
        ApiClient.getApi().getMostPopularMovies(BuildConfig.API_KEY, pageNo)
            .enqueue(object : Callback<MoviesResponse> {
                override fun onResponse(
                    call: Call<MoviesResponse>,
                    response: Response<MoviesResponse>
                ) {
                    mostPopularMovies.postValue(response.body())
                }

                override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                    mostPopularMovies.postValue(null)
                }
            })
        return mostPopularMovies
    }
}
