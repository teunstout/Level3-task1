package com.example.userprofile

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_profile.*

const val GALLERY_REQUEST_CODE = 100

class CreateProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        initViews()
    }

    private fun initViews() {
        btnGallery.setOnClickListener{ onGalleryClick() }
    }

    private fun onGalleryClick() {
        val pictureIntent = Intent(Intent.ACTION_PICK)
        pictureIntent.type = "image/*"
        startActivityForResult(pictureIntent, GALLERY_REQUEST_CODE)
    }

}