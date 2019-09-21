package com.azab.popmovies.feature.details.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.azab.data.entities.Review
import com.azab.popmovies.R
import kotlinx.android.synthetic.main.rv_review_item.view.*

class ReviewsAdapter(
    private var context: Context?,
    private val reviews: List<Review>
) : RecyclerView.Adapter<ReviewsAdapter.ReviewsViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ReviewsViewHolder {
        context = viewGroup.context
        val view = LayoutInflater.from(context).inflate(R.layout.rv_review_item, viewGroup, false)
        return ReviewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReviewsViewHolder, i: Int) {
        val review = reviews[i]
        holder.bind(review)
    }

    override fun getItemCount(): Int {
        return reviews.size
    }

    inner class ReviewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(review: Review) {
            itemView.tv_author_title.text = review.author
            itemView.tv_review_content.text = review.content
        }
    }
}