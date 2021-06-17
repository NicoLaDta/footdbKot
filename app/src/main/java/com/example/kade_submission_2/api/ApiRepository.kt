package com.example.kade_submission_2.api

import android.net.Uri
import com.example.kade_submission_2.BuildConfig
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import java.net.URL

class ApiRepository {
    fun doRequest(url: String): Deferred<String> = GlobalScope.async {
        URL(url).readText()
    }

    object TheSportDBApi {

        fun getDetailLeague(idLeague: String?): String {
            return BuildConfig.BASE_URL + "api/v1/json/40130162/lookupleague.php?id=" + idLeague
        }

        fun getPreviousMatch(idLeague: String?): String {
            return BuildConfig.BASE_URL + "api/v1/json/40130162/eventspastleague.php?id=" + idLeague
        }

        fun getUpcomingMatch(idLeague: String?): String {
            return BuildConfig.BASE_URL + "api/v1/json/40130162/eventsnextleague.php?id=" + idLeague
        }

        fun getTeamDetails(idTeams: String?): String {
            return BuildConfig.BASE_URL + "api/v1/json/40130162/lookupteam.php?id=" + idTeams
        }

        fun getMatchDetails(idEvents: String?): String {
            return BuildConfig.BASE_URL + "api/v1/json/40130162/lookupevent.php?id=" + idEvents
        }

        fun getSearchMatch(matchName: String?): String {
            return BuildConfig.BASE_URL + "api/v1/json/40130162/searchevents.php?e=" + matchName
        }

        fun getStandings(idLeague: String?): String {
            return BuildConfig.BASE_URL + "api/v1/json/40130162/lookuptable.php?l=" + idLeague
        }

        fun getTeamList(idLeague: String?): String {
            return BuildConfig.BASE_URL + "api/v1/json/40130162/lookup_all_teams.php?id=" + idLeague
        }

        fun getSearchTeam(teamName: String?): String {
            return BuildConfig.BASE_URL + "api/v1/json/40130162/searchteams.php?t=" + teamName
        }
    }
}

