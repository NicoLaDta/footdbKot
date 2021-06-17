package com.example.kade_submission_2.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Standings(

    @SerializedName("strTeam")
    val name: String? = null,

    @SerializedName("intRank")
    val teamId: String? = null,

    @SerializedName("intPlayed")
    val played: String? = null,

    @SerializedName("intGoalsFor")
    val goalsFor: Int? = null,

    @SerializedName("intWin")
    val win: Int? = null,

    @SerializedName("intDraw")
    val draw: Int? = null,

    @SerializedName("intLoss")
    val loss: Int? = null,

    @SerializedName("intPoints")
    val total: Int? = null
): Parcelable

data class StandingsResponse(

    @SerializedName("table")
    val standingsResponse: List<Standings>
)