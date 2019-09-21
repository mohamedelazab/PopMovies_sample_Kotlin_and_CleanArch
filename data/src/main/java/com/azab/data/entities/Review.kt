package com.azab.data.entities

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity
data class Review(
    @SerializedName("author")
    val author:String?,
    @SerializedName("content")
    val content:String?
)