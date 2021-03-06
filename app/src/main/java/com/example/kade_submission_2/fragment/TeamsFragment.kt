package com.example.kade_submission_2.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.kade_submission_2.R
import com.example.kade_submission_2.activity.DetailLigaActivity
import com.example.kade_submission_2.activity.DetailTeamActivity
import com.example.kade_submission_2.adapter.TeamAdapter
import com.example.kade_submission_2.api.ApiRepository
import com.example.kade_submission_2.model.Teams
import com.example.kade_submission_2.presenter.TeamListPresenter
import com.example.kade_submission_2.presenter.TeamsPresenter
import com.example.kade_submission_2.view.ListTeamView
import com.example.kade_submission_2.view.TeamsView
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_teams.*
import org.jetbrains.anko.startActivity

/**
 * A simple [Fragment] subclass.
 */
class TeamsFragment : Fragment(), ListTeamView {

    private lateinit var presenter: TeamListPresenter
    private lateinit var adapter: TeamAdapter
    private var items: MutableList<Teams> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_teams, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val apiRepository = ApiRepository()
        val gson = Gson()

        presenter = TeamListPresenter(this, apiRepository, gson)
        presenter.getListTeam(DetailLigaActivity.idLeague)

        adapter = TeamAdapter(context, items) {
            context?.startActivity<DetailTeamActivity>(DetailTeamActivity.ARGS_ID to "${it.idTeam}")
        }

        rvTeam.layoutManager = LinearLayoutManager(context)
        rvTeam.adapter = adapter
    }

    override fun showListTeam(data: List<Teams>) {
        items.clear()
        items.addAll(data)
        adapter.notifyDataSetChanged()
    }


}
