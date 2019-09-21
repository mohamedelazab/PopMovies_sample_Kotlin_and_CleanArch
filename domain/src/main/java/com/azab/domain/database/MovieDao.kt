package com.azab.domain.database

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.azab.data.entities.Movie
import retrofit2.http.DELETE

interface MovieDao {

    @Insert
    fun insert(movie: Movie)

    @Query("SELECT * FROM Movie")
    fun getAllSavedMovies(): LiveData<List<Movie>>

    @Delete
    fun deleteMovie(movie: Movie)

}