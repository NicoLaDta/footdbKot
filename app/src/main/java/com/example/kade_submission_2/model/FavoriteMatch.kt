package com.example.kade_submission_2.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FavoriteMatch(
    val idEvent: String? = null,

    val strEvent: String? = null,

    val intHomeScore: String? = null,

    val intAwayScore: String? = null,

    val dateEvent: String? = null,

    val idHomeTeam: String? = null,

    val idAwayTeam: String? = null,

    val strVenue: String? = null,

    val strCountry: String? = null,


): Parcelable