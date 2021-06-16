package com.example.kade_submission_2.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class DetailLiga(
    @SerializedName("dateFirstEvent")
    val dateLeague: String? = null,

    @SerializedName("strDescriptionEN")
    val descLeague: String? = null
)

data class LeagueResponse (
    @SerializedName("leagues")
    val league: List<DetailLiga?>? = null
)