package com.azab.popmovies.feature.home

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.azab.data.entities.Movie
import com.azab.popmovies.BuildConfig
import com.azab.popmovies.R
import com.azab.popmovies.feature.home.listener.MoviesListener
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.rv_movie_item.view.*

class MoviesAdapter(
    private var context: Context?,
    private val movies: List<Movie>,
    private val listener: MoviesListener
) : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): MoviesViewHolder {
        context = viewGroup.context
        val view = LayoutInflater.from(context).inflate(R.layout.rv_movie_item, viewGroup, false)
        return MoviesViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, i: Int) {
        val movie = movies[i]
        holder.bind(movie)
        holder.itemView.setOnClickListener { listener.onMovieItemClicked(movie) }
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    inner class MoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(movie: Movie) {
            itemView.tv_movie_title.text = movie.title
            itemView.tv_release_date.text =
                context?.getString(R.string.release_date, movie.releaseDate)
            itemView.tv_rating.text = context?.getString(R.string.rating, movie.rating)
            Picasso.get().load(BuildConfig.MAIN_POSTER_BASE + movie.posterPath)
                .placeholder(R.drawable.ic_placeholder).into(itemView.img_movie_poster)
        }
    }
}
