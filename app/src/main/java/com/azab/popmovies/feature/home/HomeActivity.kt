package com.azab.popmovies.feature.home

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.azab.data.entities.Movie
import com.azab.data.entities.MoviesResponse
import com.azab.popmovies.R
import com.azab.popmovies.feature.home.details.DetailsActivity
import com.azab.popmovies.feature.home.listener.MoviesListener
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), MoviesListener {

    val homeViewModel: HomeViewModel by lazy {
        ViewModelProviders.of(this).get(HomeViewModel::class.java)
    }
    val moviesAdapter: MoviesAdapter by lazy { MoviesAdapter(this, movies, this) }

    var movies = ArrayList<Movie>()
    val pageNo = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val gridLayoutManager = GridLayoutManager(this, 2)
        rvMovies.layoutManager = gridLayoutManager
        rvMovies.adapter = moviesAdapter
        getMostPopular(pageNo)
    }

    private fun getMostPopular(pageNo: Int) {
        homeViewModel.getMostPopularMovies(pageNo).observe(this, Observer<MoviesResponse> {
            it?.moviesList?.let { it1 ->
                movies.addAll(
                    it1
                )
            }
            moviesAdapter.notifyDataSetChanged()
        })
    }

    override fun onMovieItemClicked(movie: Movie) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("movie", movie)
        startActivity(intent)
    }
}
