package com.jayu.allinonenews.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.widget.Toolbar
import com.google.android.gms.ads.*
import com.jayu.allinonenews.R

class WebViewActivity : AppCompatActivity() {

    private lateinit var webView : WebView
    private lateinit var toolbar : Toolbar
    private lateinit var url : String
    private lateinit var mAdView : AdView
    private lateinit var mInterstitialAd: InterstitialAd

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        webView = findViewById(R.id.webView)
        toolbar = findViewById(R.id.toolbar)
        mAdView = findViewById(R.id.webAds)

        val adView = AdView(this)
        adView.adSize = AdSize.BANNER
        adView.adUnitId = getString(R.string.aionBanner)

        MobileAds.initialize(this){}
        mAdView.loadAd(AdRequest.Builder().build())

        setUpToolbar()
    }

    private fun setUpToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.title = "News"
    }

    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            finish()
        }
    }
}