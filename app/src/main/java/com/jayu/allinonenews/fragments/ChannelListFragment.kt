package com.jayu.allinonenews.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jayu.allinonenews.R
import com.jayu.allinonenews.adapters.ChannelListRecyclerAdapter
import com.jayu.allinonenews.utils.Arrays
import com.jayu.allinonenews.utils.toast

class ChannelListFragment : Fragment() {

    private lateinit var channelListRecyclerView: RecyclerView
    private lateinit var channelListLayoutManager: RecyclerView.LayoutManager
    private lateinit var channelListRecyclerAdapter : ChannelListRecyclerAdapter

    private val arrays = Arrays()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_channel_list, container, false)

        channelListRecyclerView = view.findViewById(R.id.channelListRecyclerView)
        channelListLayoutManager = GridLayoutManager(activity as Context,2)
        channelListRecyclerAdapter = ChannelListRecyclerAdapter(activity as Context,arrays.channelListArray)
        channelListRecyclerView.adapter = channelListRecyclerAdapter
        channelListRecyclerView.layoutManager = channelListLayoutManager

        return view
    }
}