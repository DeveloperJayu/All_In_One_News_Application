package com.jayu.allinonenews.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.google.android.gms.ads.*
import com.jayu.allinonenews.R
import com.jayu.allinonenews.fragments.ChannelListFragment
import com.jayu.allinonenews.utils.toast

class MainActivity : AppCompatActivity() {

    private lateinit var toolbar : Toolbar
    private lateinit var mAdView : AdView
    private lateinit var mInterstitialAd: InterstitialAd
    private lateinit var mInterstitialAdExit: InterstitialAd

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)

        val adView = AdView(this)
        adView.adSize = AdSize.BANNER
        adView.adUnitId = getString(R.string.aionBanner)

        MobileAds.initialize(this){}
        mAdView = findViewById(R.id.mainAds)
        mAdView.loadAd(AdRequest.Builder().build())

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