package com.prabhakaran.memesapplication.feature.memes.presentation

import android.R
import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.prabhakaran.memesapplication.common.data.model.Meme
import com.prabhakaran.memesapplication.databinding.FragmentItemBinding


/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyItemRecyclerViewAdapter(private val context: Context,
    private val values: List<Meme>
) : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.idView.text = item.id
        holder.contentView.text = item.name


        Glide.with(context)
            .load(item.url) // image url
            .placeholder(R.drawable.ic_input_get) // any placeholder to load at start
            .error(R.drawable.stat_notify_error)  // any image in case of error
            .override(200, 200) // resizing
            .centerCrop()
            .into(holder.image);


    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.itemNumber
        val contentView: TextView = binding.content
        val image: ImageView = binding.img

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }

}