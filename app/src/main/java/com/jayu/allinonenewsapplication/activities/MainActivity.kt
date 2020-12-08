package com.jayu.allinonenewsapplication.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jayu.allinonenewsapplication.R
import com.jayu.allinonenewsapplication.adapters.ChannelListRecyclerAdapter
import com.jayu.allinonenewsapplication.fragments.ChannelListFragment
import com.jayu.allinonenewsapplication.utils.Arrays

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment,ChannelListFragment())
            .commit()
    }
}