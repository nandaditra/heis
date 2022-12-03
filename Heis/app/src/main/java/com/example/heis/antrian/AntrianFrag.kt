package com.example.heis.antrian

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.heis.R

class AntrianFrag : Fragment() {
    private lateinit var rvAntrian: RecyclerView
    private var list: ArrayList<Antrian> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_antrian, container, false)

        rvAntrian = view.findViewById(R.id.rv_antrian)
        rvAntrian.setHasFixedSize(true)

        list.addAll(AntriansData.listData)
        showRecyclerList()

        return view
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_antrian)
//
//        rvAntrian = findViewById(R.id.rv_antrian)
//        rvAntrian.setHasFixedSize(true)
//
//        list.addAll(AntriansData.listData)
//        showRecyclerList()
//    }

    private fun showRecyclerList() {
        rvAntrian.layoutManager = LinearLayoutManager(activity)
        val listTravelAdapter = ListAntrianAdapter(list)
        rvAntrian.adapter = listTravelAdapter

    }
}