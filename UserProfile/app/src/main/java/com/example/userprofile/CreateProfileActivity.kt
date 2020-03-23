package com.example.userprofile

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_profile.*

const val GALLERY_REQUEST_CODE = 100

class CreateProfileActivity : AppCompatActivity() {
    private var profileImageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        btnGallery.setOnClickListener { onGalleryClick() }
        btnConfirm.setOnClickListener { onConfirmClick() }
    }

    private fun onConfirmClick() {
        if (dataFielsAreEmpty()) return // check if name and surname fields are filled in
        val profile = Profile(
            txtInName.text.toString(),
            txtInSurname.text.toString(),
            txtInDescription.text.toString(),
            profileImageUri
        )
//         if wanted could clear fields with
//         txtInName.text?.clear()

        val profileActivityIntent =
            Intent(this, ProfileActivity::class.java)
                .putExtra(PROFILE_EXTRA, profile)
        startActivity(profileActivityIntent)
    }

    /**
     * check if name and surname are filled in
     */
    private fun dataFielsAreEmpty(): Boolean {
        return when (true) {
            (txtInName.text.toString() == "") -> {
                toast(R.string.fillInName); true
            }
            (txtInSurname.text.toString() == "") -> {
                toast(R.string.fillInSurname); true
            }
            else -> false
        }
    }

    /**
     * toast
     */
    private fun toast(message: Int) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }


    /**
     * intent for opening gallery and open pics
     */
    private fun onGalleryClick() {
        // Create an Intent with action as ACTION_PICK
        val galleryIntent = Intent(Intent.ACTION_PICK)

        // Sets the type as image/*. This ensures only components of type image are selected
        galleryIntent.type = "image/*"

        // Start the activity using the gallery intent
        startActivityForResult(galleryIntent, GALLERY_REQUEST_CODE)
    }


    /**
     * If inent is finished and there is a picture save URL so we can use picture
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                GALLERY_REQUEST_CODE -> {
                    profileImageUri = data?.data
                    imgUpload.setImageURI(profileImageUri)
                }
            }
        }
    }

}
