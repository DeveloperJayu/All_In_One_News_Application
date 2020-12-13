package com.jayu.allinonenews.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.appcompat.widget.Toolbar
import com.google.android.gms.ads.*
import com.jayu.allinonenews.R

class WebViewActivity : AppCompatActivity() {

    private lateinit var webView : WebView
    private lateinit var toolbar : Toolbar
    private lateinit var url : String
    private lateinit var mAdView : AdView
    private lateinit var mInterstitialAd: InterstitialAd
    private lateinit var progressBar : ProgressBar

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        webView = findViewById(R.id.webView)
        toolbar = findViewById(R.id.toolbar)
        mAdView = findViewById(R.id.webAds)
        progressBar = findViewById(R.id.progressBar)

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
        mInterstitialAd = InterstitialAd(this)
        mInterstitialAd.adUnitId = getString(R.string.aionInterstital)
        mInterstitialAd.loadAd(AdRequest.Builder().build())

        webView.webViewClient = WebViewClient()
        webView.loadUrl(url)
        webView.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView, progress: Int) {
                progressBar.visibility = View.VISIBLE

                if (progress == 100) progressBar.visibility = View.GONE
            }
        }
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

            R.id.openInBrowser->{
                if (mInterstitialAd.isLoaded) {
                    mInterstitialAd.show()
                }
                val uri = Uri.parse(url)
                val intent = Intent(Intent.ACTION_VIEW,uri)
                startActivity(intent)
                finish()
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }
}