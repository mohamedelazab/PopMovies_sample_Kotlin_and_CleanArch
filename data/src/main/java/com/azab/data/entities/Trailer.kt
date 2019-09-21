package com.azab.data.entities

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity
data class Trailer(
    @SerializedName("id")
     var id: String?,
    @SerializedName("key")
     var key: String?,
    @SerializedName("name")
     var name: String?,
    @SerializedName("site")
     var site: String?,
    @SerializedName("type")
     var type: String?
)