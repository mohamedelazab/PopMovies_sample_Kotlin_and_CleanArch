package com.azab.popmovies.feature.home.details

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.azab.data.entities.*
import com.azab.popmovies.BuildConfig
import com.azab.popmovies.R
import com.azab.popmovies.feature.details.DetailsViewModel
import com.azab.popmovies.feature.details.TrailersListener
import com.azab.popmovies.feature.details.adapter.ReviewsAdapter
import com.azab.popmovies.feature.details.adapter.TrailersAdapter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.content_details.*
import java.lang.Exception

class DetailsActivity : AppCompatActivity(), TrailersListener {

    val detailsViewModel: DetailsViewModel by lazy {
        ViewModelProviders.of(this).get(DetailsViewModel::class.java)
    }
    val reviewsAdapter: ReviewsAdapter by lazy { ReviewsAdapter(this, reviews) }
    val trailersAdapter: TrailersAdapter by lazy { TrailersAdapter(this, trailers, this) }
    val movie: Movie by lazy { intent?.extras?.getParcelable("movie") as Movie }

    var reviews = ArrayList<Review>()
    var trailers = ArrayList<Trailer>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_details)
        getMovieData()
        rv_trailers.adapter = trailersAdapter
        rv_reviews.adapter = reviewsAdapter
        getReviews(movie.id)
        getTrailers(movie.id)

    }

    private fun getTrailers(movieId: Int) {
        detailsViewModel.getTrailer(movieId).observe(this, Observer<TrailersResponse> {
            it?.trailers?.let { it1 ->
                trailers.addAll(
                    it1
                )
            }
            trailersAdapter.notifyDataSetChanged()
        })
    }

    private fun getReviews(movieId: Int) {
        detailsViewModel.getReviews(movieId).observe(this, Observer<ReviewsResponse> {
            it?.reviews?.let { it1 ->
                reviews.addAll(
                    it1
                )
            }
            reviewsAdapter.notifyDataSetChanged()
        })
    }

    private fun getMovieData() {
        Picasso.get().load(BuildConfig.BACK_POSTER_BASE + movie.backPoster)
            .placeholder(R.drawable.ic_placeholder).into(collapse_img_back_poster)
        tv_movie_title.text = movie.title
        tv_rating.text = getString(R.string.rating, movie.rating)
        tv_release_date.text = getString(R.string.release_date, movie.releaseDate)
    }

    override fun onTrailerClicked(trailer: Trailer) {
        val appIntent: Intent = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + trailer.key));
        val webIntent: Intent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("http://www.youtube.com/watch?v=" + trailer.key)
        )

        try {
            this.startActivity(appIntent);
        } catch (e: Exception) {
            this.startActivity(webIntent);
        }
    }
}