package com.example.kade_submission_2.view

import com.example.kade_submission_2.model.Teams

interface TeamsView {
    fun showTeams(homeTeams: List<Teams>, awayTeams: List<Teams>)
}
