package com.example.kade_submission_2.view

import com.example.kade_submission_2.model.Match


interface UpcomingMatchView {
    fun showUpcomingMatch(data: List<Match>)
}