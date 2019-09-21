package com.azab.popmovies.feature.details.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.azab.data.entities.Trailer
import com.azab.popmovies.R
import com.azab.popmovies.feature.details.TrailersListener
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.rv_trailer_item.view.*


class TrailersAdapter(
    private var context: Context?,
    private val trailers: List<Trailer>,
    private val listener: TrailersListener
) : RecyclerView.Adapter<TrailersAdapter.TrailersViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): TrailersViewHolder {
        context = viewGroup.context
        val view = LayoutInflater.from(context).inflate(R.layout.rv_trailer_item, viewGroup, false)
        return TrailersViewHolder(view)
    }

    override fun onBindViewHolder(holder: TrailersViewHolder, i: Int) {
        val trailer = trailers[i]
        holder.bind(trailer)
        holder.itemView.setOnClickListener { listener.onTrailerClicked(trailer) }
    }

    override fun getItemCount(): Int {
        return trailers.size
    }

    inner class TrailersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(trailer: Trailer) {
            val trailerThumbnailUrl =
                "https://img.youtube.com/vi/" + trailer.key + "/mqdefault.jpg"
            Picasso.get().load(trailerThumbnailUrl).placeholder(R.drawable.ic_placeholder)
                .into(itemView.img_trailer)
            itemView.tv_trailer_title.text =trailer.name

        }
    }
}
