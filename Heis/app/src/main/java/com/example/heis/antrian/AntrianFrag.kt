package com.example.heis.antrian

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.heis.AntrianViewModel
import com.example.heis.MainActivity
import com.example.heis.R
import com.example.heis.SecondActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class AntrianFrag : Fragment() {

    private lateinit var rvAntrian: RecyclerView
    val antrianVM: AntrianViewModel by activityViewModels()
    var adapter = AntrianAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_antrian, container, false)

        rvAntrian = view.findViewById(R.id.rv_antrian)
        rvAntrian.setHasFixedSize(true)

        rvAntrian.layoutManager = LinearLayoutManager(activity)
        rvAntrian.adapter = adapter

        adapter.setOnItemClickListener(object: AntrianAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                val nomor = activity?.getSharedPreferences(MainActivity.SHARED, Context.MODE_PRIVATE)?.getInt(MainActivity.NOMOR_ANTRIAN, -1)

                if (adapter.getItems().get(position).nomorAntrian == nomor) {
                    val intent = Intent(context, SecondActivity::class.java)
                    intent.putExtra(MainActivity.PASIEN, adapter.getItems().get(position))
                    intent.putExtra(MainActivity.TOP_NUMBER, adapter.getItems().get(0).nomorAntrian)
                    activity?.startActivity(intent)
                } else {
                    Toast.makeText(context, "Tidak dapat mengakses informasi orang lain", Toast.LENGTH_SHORT).show()
                }
            }
        })

        loadData()

        return view
    }

    fun loadData() {
        antrianVM.get().addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val pasiens = ArrayList<Pasien>()
                for (item in snapshot.children) {
                    val pasien = item.getValue(Pasien::class.java)
                    if (pasien != null)
                        pasiens.add(pasien)
                }
                adapter.clear()
                adapter.setItems(pasiens)
                Log.v("antrian count", adapter.itemCount.toString())
                antrianVM.setCount(adapter.itemCount)
                adapter.notifyItemInserted(adapter.itemCount)
            }

            override fun onCancelled(error: DatabaseError) {
                Log.v("loaddata", error.toException().toString())
            }
        })
    }
}