package com.jayu.allinonenews.activities

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.widget.Toolbar
import com.google.android.gms.ads.*
import com.jayu.allinonenews.R

class WebViewActivity : AppCompatActivity() {

    private lateinit var webView : WebView
    private lateinit var toolbar : Toolbar
    private lateinit var url : String
    private lateinit var mAdView : AdView
    private lateinit var mInterstitialAd: InterstitialAd

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        webView = findViewById(R.id.webView)
        toolbar = findViewById(R.id.toolbar)
        mAdView = findViewById(R.id.webAds)

        val webSetting = webView.settings
        setUpToolbar()

        if (intent!=null){
            url = intent.getStringExtra("url") ?: ""
        }

        //Ads
        val adView = AdView(this)
        adView.adSize = AdSize.BANNER
        adView.adUnitId = getString(R.string.aionBanner)

        MobileAds.initialize(this){}
        mAdView.loadAd(AdRequest.Builder().build())

        webView.webViewClient = WebViewClient()
        webView.loadUrl(url)
        webSetting.domStorageEnabled = true
        webSetting.javaScriptEnabled = true

    }

    private fun setUpToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.title = "News"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_close_24)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }
    
    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            finish()
        }
    }
}