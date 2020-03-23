package com.example.userprofile

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.activity_profile_personolized.*

const val PROFILE_EXTRA = "PROFILE_EXTRA"

class ProfileActivity: AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_personolized)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "This is your profile!"

        initViews()
    }

    private fun initViews() {
        val profile = intent.getParcelableExtra<Profile>(PROFILE_EXTRA) // get intent data

        // put data in the view
        if (profile != null) {
            titlePerProfile.text = getString(R.string.name, profile.name, profile.surname)
            disPerProfile.text = profile.description
            if (profile.img != null) imgUpload.setImageURI(profile.img)
        }
    }

    /**
     * when clicked on back button go back
     */
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}