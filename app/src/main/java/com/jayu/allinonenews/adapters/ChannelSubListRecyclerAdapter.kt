package com.jayu.allinonenews.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jayu.allinonenews.R
import com.jayu.allinonenews.models.ChannelSubList
import com.jayu.allinonenews.utils.toast

class ChannelSubListRecyclerAdapter(val context : Context, val channelSubList : ArrayList<ChannelSubList>) : RecyclerView.Adapter<ChannelSubListRecyclerAdapter.viewHolder>() {
    class viewHolder(view : View) : RecyclerView.ViewHolder(view){
        val parentId : TextView = view.findViewById(R.id.channelParentId)
        val id : TextView = view.findViewById(R.id.channelSubListId)
        val url : TextView = view.findViewById(R.id.channelUrl)
        val name : TextView = view.findViewById(R.id.txtChannelSubListName)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): viewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_channel_sub_list_single_row,parent,false)

        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val number = channelSubList[position]
        holder.parentId.text = number.parentId.toString()
        holder.id.text = number.id.toString()
        holder.url.text = number.url
        holder.name.text = number.name

        holder.itemView.setOnClickListener{
            context.toast(number.url)
        }
    }

    override fun getItemCount(): Int {
        return channelSubList.size
    }

}