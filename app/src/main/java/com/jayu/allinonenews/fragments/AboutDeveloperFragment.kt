package com.jayu.allinonenews.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.google.android.material.navigation.NavigationView
import com.jayu.allinonenews.R
import com.jayu.allinonenews.utils.URLConstants

class AboutDeveloperFragment : Fragment() {

    private lateinit var toolbar : Toolbar
    private lateinit var imgGitHub : ImageView
    private lateinit var imgTelegram : ImageView
    private lateinit var imgInstagram : ImageView
    private lateinit var imgTwitter : ImageView
    private lateinit var imgLinkedIn : ImageView
    private lateinit var imgGmail : ImageView
    private lateinit var aboutMeDescription : TextView
    val url = URLConstants()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_about_developer, container, false)
        val navView: NavigationView = activity!!.findViewById(R.id.navigationView)

        toolbar = activity!!.findViewById(R.id.toolbar)
        toolbar.title = "About Developer"
        imgGitHub = view.findViewById(R.id.imgGitHub)
        imgTelegram = view.findViewById(R.id.imgTelegram)
        imgInstagram = view.findViewById(R.id.imgInstagram)
        imgTwitter = view.findViewById(R.id.imgTwitter)
        imgLinkedIn = view.findViewById(R.id.imgLinkedIn)
        imgGmail = view.findViewById(R.id.imgGmail)
        aboutMeDescription = view.findViewById(R.id.aboutMeDescription)
        navView.setCheckedItem(R.id.aboutDeveloper)

        aboutMeDescription.text = context?.getString(R.string.developerDescription)

        //Contact Me Buttons
        imgGitHub.setOnClickListener {
            val uri = Uri.parse(url.githubUrl)
            val intent = Intent(Intent.ACTION_VIEW,uri)
            startActivity(intent)
        }

        imgTelegram.setOnClickListener {
            val uri = Uri.parse(url.telegramUrl)
            val intent = Intent(Intent.ACTION_VIEW,uri)
            startActivity(intent)
        }

        imgInstagram.setOnClickListener {
            val uri = Uri.parse(url.instaUrl)
            val intent = Intent(Intent.ACTION_VIEW,uri)
            startActivity(intent)
        }

        imgTwitter.setOnClickListener {
            val uri = Uri.parse(url.twitterUrl)
            val intent = Intent(Intent.ACTION_VIEW,uri)
            startActivity(intent)
        }

        imgLinkedIn.setOnClickListener {
            val uri = Uri.parse(url.linkedinUrl)
            val intent = Intent(Intent.ACTION_VIEW,uri)
            startActivity(intent)
        }

        imgGmail.setOnClickListener {
            val uri = Uri.parse(url.gmailUrl)
            val intent = Intent(Intent.ACTION_VIEW,uri)
            startActivity(intent)
        }

        return view
    }

}