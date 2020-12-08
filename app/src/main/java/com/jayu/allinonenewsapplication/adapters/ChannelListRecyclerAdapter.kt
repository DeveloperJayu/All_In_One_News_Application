package com.jayu.allinonenewsapplication.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jayu.allinonenewsapplication.R
import com.jayu.allinonenewsapplication.models.Channel
import kotlinx.android.synthetic.main.item_newschannel_single_row.view.*

class ChannelListRecyclerAdapter(val context: Context, val channelList:ArrayList<Channel>) : RecyclerView.Adapter<ChannelListRecyclerAdapter.viewHolder>(){
    class viewHolder(view : View) : RecyclerView.ViewHolder(view){
        val channelId : TextView = view.findViewById(R.id.channelId)
        val channelName : TextView = view.findViewById(R.id.channelName)
        val channelImage : ImageView = view.findViewById(R.id.channelImage)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChannelListRecyclerAdapter.viewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_newschannel_single_row,parent,false)

        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: ChannelListRecyclerAdapter.viewHolder, position: Int) {
        val number = channelList[position]
        holder.channelId.text = number.channelId.toString()
        holder.channelName.text = number.channelName
        holder.channelImage.setImageResource(number.newsImage)
    }

    override fun getItemCount(): Int {
        return channelList.size
    }

}