package com.azab.data.entities

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity
data class Movie(

    @PrimaryKey
    @SerializedName("id")
     val id: Int,
    @SerializedName("title")
     val title: String?,
    @SerializedName("poster_path")
     val posterPath: String?,
    @SerializedName("backdrop_path")
     val backPoster: String?,
    @SerializedName("overview")
     val overview: String?,
    @SerializedName("release_date")
     val releaseDate: String?,
    @SerializedName("vote_average")
     val rating: String?,

     val isFav: Boolean = false
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readByte() != 0.toByte()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(title)
        parcel.writeString(posterPath)
        parcel.writeString(backPoster)
        parcel.writeString(overview)
        parcel.writeString(releaseDate)
        parcel.writeString(rating)
        parcel.writeByte(if (isFav) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Movie> {
        override fun createFromParcel(parcel: Parcel): Movie {
            return Movie(parcel)
        }

        override fun newArray(size: Int): Array<Movie?> {
            return arrayOfNulls(size)
        }
    }
}