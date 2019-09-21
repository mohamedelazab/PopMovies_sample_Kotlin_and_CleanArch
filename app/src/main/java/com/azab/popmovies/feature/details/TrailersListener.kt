package com.azab.popmovies.feature.details

import com.azab.data.entities.Trailer

interface TrailersListener {
    fun onTrailerClicked(trailer: Trailer)
}
