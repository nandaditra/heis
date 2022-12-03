package com.example.heis.ui.antrian

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.heis.R

class AntrianActivity : AppCompatActivity() {
    private lateinit var rvAntrian: RecyclerView
    private var list: ArrayList<Antrian> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_antrian)

        rvAntrian = findViewById(R.id.rv_antrian)
        rvAntrian.setHasFixedSize(true)

        list.addAll(AntriansData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvAntrian.layoutManager = LinearLayoutManager(this)
        val listTravelAdapter = ListAntrianAdapter(list)
        rvAntrian.adapter = listTravelAdapter

    }
}