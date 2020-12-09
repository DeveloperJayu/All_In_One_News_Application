package com.jayu.allinonenews.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.jayu.allinonenews.R
import com.jayu.allinonenews.fragments.ChannelListFragment

class MainActivity : AppCompatActivity() {

    private lateinit var toolbar : Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)

        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment,ChannelListFragment())
            .commit()

        setUpToolbar()
    }

    private fun setUpToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Home"
    }

}