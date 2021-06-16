package com.example.kade_submission_2.view

import com.example.kade_submission_2.model.DetailTeam
import com.example.kade_submission_2.model.Teams


interface DetailTeamView{
    fun showTeamDetail(data: List<DetailTeam>)
}