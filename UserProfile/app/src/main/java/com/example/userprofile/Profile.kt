package com.example.userprofile

import android.net.Uri
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Profile(
    val name: String,
    val surname: String,
    val description: String,
    val img: Uri?
) : Parcelable
{
}