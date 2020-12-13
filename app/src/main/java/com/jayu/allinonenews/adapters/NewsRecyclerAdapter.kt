package com.jayu.allinonenews.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jayu.allinonenews.R
import com.jayu.allinonenews.activities.WebViewActivity
import com.jayu.allinonenews.models.News
import com.squareup.picasso.Picasso

class NewsRecyclerAdapter(val context: Context,val newsList : ArrayList<News>) : RecyclerView.Adapter<NewsRecyclerAdapter.viewHolder>() {
    class viewHolder(view : View) : RecyclerView.ViewHolder(view){
        val title : TextView = view.findViewById(R.id.newsTitle)
        val image : ImageView = view.findViewById(R.id.newsImage)
        val link : TextView = view.findViewById(R.id.newsUrl)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): viewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_news_single_row,parent,false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val number = newsList[position]
        holder.title.text = number.title
        holder.link.text = number.link
        if (number.image.isNotEmpty()){
            Picasso.get().load(number.image).into(holder.image)
        }

        holder.itemView.setOnClickListener {
            val intent = Intent(context,WebViewActivity::class.java)
            intent.putExtra("url",number.link)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

}