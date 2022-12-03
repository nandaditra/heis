package com.example.heis

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.*

class AntrianViewModel : ViewModel() {

    val antrian = MutableLiveData<ArrayList<Pasien>>()
    val ref = FirebaseDatabase.getInstance("https://heis-82a96-default-rtdb.asia-southeast1.firebasedatabase.app").getReference("Antrian")
    var counter = 0

    init {
        antrian.value = ArrayList()
        loadData()
    }

    fun add(pasien: Pasien) {
        pasien.nomorAntrian = counter + 1
        ref.push().setValue(pasien)
    }

    fun loadData() {
        ref.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                antrian.value?.clear()
                for (item in snapshot.children) {
                    val pasien = item.getValue(Pasien::class.java)
                    if (pasien != null) {
                        antrian.value?.add(pasien)
                        Log.v("loadData", pasien.toString())
                        counter = pasien.nomorAntrian

                    } else {
                        Log.v("loadData", "null")
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.v("loadData", "Failed to read value", error.toException())
            }
        })
    }

    fun remove(nama: String) {
        antrian.value?.filter {it.nama != nama}
    }

    fun showList() {
        if (antrian.value != null) {
            for (item in antrian.value!!) {
                Log.v("showlist", item.nama)
            }
        } else {
            Log.v("showlist", "null")
        }
    }
}