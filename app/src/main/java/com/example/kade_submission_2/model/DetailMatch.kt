package com.example.kade_submission_2.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class DetailMatch(

    @SerializedName("idEvent")
    val idEvent: String? = null,

    @SerializedName("strLeague")
    val strLeague: String? = null,

    @SerializedName("strEvent")
    val strEvent: String? = null,

    @SerializedName("strHomeTeam")
    val strHomeTeam: String? = null,

    @SerializedName("strAwayTeam")
    val strAwayTeam: String? = null,

    @SerializedName("intHomeScore")
    val intHomeScore: String? = null,

    @SerializedName("intAwayScore")
    val intAwayScore: String? = null,

    @SerializedName("strHomeFormation")
    val strHomeFormation: String? = null,

    @SerializedName("strAwayFormation")
    val strAwayFormation: String? = null,

    @SerializedName("strHomeGoalDetails")
    val strHomeGoalDetails: String? = null,

    @SerializedName("strAwayGoalDetails")
    val strAwayGoalDetails: String? = null,

    @SerializedName("dateEvent")
    val dateEvent: String? = null,

    @SerializedName("strThumb")
    val strThumb: String? = null,

    @SerializedName("idHomeTeam")
    val idHomeTeam: String? = null,

    @SerializedName("idAwayTeam")
    val idAwayTeam: String? = null,

    @SerializedName("strVenue")
    val strVenue: String? = null,

    @SerializedName("strCountry")
    val strCountry: String? = null




): Parcelable

data class DetailMatchRespose(

    @SerializedName("events")
    val detailMatchResponse: List<DetailMatch?>? = null

)