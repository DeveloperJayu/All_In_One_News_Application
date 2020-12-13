package com.jayu.allinonenews.activities

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.google.android.material.navigation.NavigationView
import com.jayu.allinonenews.R
import com.jayu.allinonenews.fragments.AboutAppFragment
import com.jayu.allinonenews.fragments.AboutDeveloperFragment
import com.jayu.allinonenews.fragments.ChannelListFragment

class MainActivity : AppCompatActivity() {

    private lateinit var toolbar : Toolbar
    private lateinit var mAdView : AdView
    private lateinit var drawerLayout : DrawerLayout
    private lateinit var navigationView : NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.navigationView)
        setUpToolbar()

        val adView = AdView(this)
        adView.adSize = AdSize.BANNER
        adView.adUnitId = getString(R.string.aionBanner)

        MobileAds.initialize(this){}
        mAdView = findViewById(R.id.mainAds)
        mAdView.loadAd(AdRequest.Builder().build())

        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this@MainActivity,
            drawerLayout,
            R.string.open_drawer,
            R.string.close_drawer
        )

        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment, ChannelListFragment())
            .commit()

        navigationView.setNavigationItemSelectedListener{

            if (it.itemId == R.id.home){
                supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment, ChannelListFragment())
                    .commit()
                for (i in 0 until supportFragmentManager.backStackEntryCount){
                    supportFragmentManager.popBackStack()
                }
                drawerLayout.closeDrawers()
            }
            if(it.itemId == R.id.aboutApp){
                supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment, AboutAppFragment())
                    .addToBackStack(null)
                    .commit()
                drawerLayout.closeDrawers()
            }
            if(it.itemId == R.id.aboutDeveloper){
                supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment, AboutDeveloperFragment())
                    .addToBackStack(null)
                    .commit()
                drawerLayout.closeDrawers()
            }

            return@setNavigationItemSelectedListener true
        }
    }

    private fun setUpToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Home"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if(id == android.R.id.home){
            drawerLayout.openDrawer(GravityCompat.START)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
