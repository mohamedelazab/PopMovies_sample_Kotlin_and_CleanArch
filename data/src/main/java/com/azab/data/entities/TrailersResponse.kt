package com.azab.data.entities

import com.google.gson.annotations.SerializedName

data class TrailersResponse(
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("results")
    var trailers: List<Trailer>? = null
)