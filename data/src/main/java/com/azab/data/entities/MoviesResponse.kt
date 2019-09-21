package com.azab.data.entities

import com.google.gson.annotations.SerializedName
import java.util.*

data class MoviesResponse(
    @SerializedName("page") val page: Int?,
    @SerializedName("total_results") val totalResults: Int?,
    @SerializedName("total_pages") val totalPages: Int?,
    @SerializedName("results") val moviesList: ArrayList<Movie>?

)