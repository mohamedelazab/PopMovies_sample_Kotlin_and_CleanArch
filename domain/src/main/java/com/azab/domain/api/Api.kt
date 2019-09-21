package com.azab.domain.api

import com.azab.data.entities.MoviesResponse
import com.azab.data.entities.ReviewsResponse
import com.azab.data.entities.TrailersResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {

    @GET("movie/popular/")
    fun getMostPopularMovies(@Query("api_key") API_KEY: String, @Query("page") page: Int?): Call<MoviesResponse>

    @GET("movie/top_rated/")
    fun getTopRatedMovies(@Query("api_key") API_KEY: String, @Query("page") page: Int?): Call<MoviesResponse>

    @GET("movie/{id}/videos")
    fun getTrailers(@Path("id") movieId: Int, @Query("api_key") apiKey: String): Call<TrailersResponse>

    @GET("movie/{id}/reviews")
    fun getReviews(@Path("id") movieId: Int, @Query("api_key") apiKey: String): Call<ReviewsResponse>

}