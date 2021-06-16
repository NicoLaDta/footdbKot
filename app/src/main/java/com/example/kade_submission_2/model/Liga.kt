package com.example.kade_submission_2.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class  Liga(
    val name: String?,
    val image: Int?,
    val id: String? = null
): Parcelable