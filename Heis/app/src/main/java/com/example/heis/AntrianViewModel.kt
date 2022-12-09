package com.example.heis

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.heis.antrian.Pasien
import com.google.firebase.database.*

class AntrianViewModel : ViewModel() {

    val antrian = MutableLiveData<ArrayList<Pasien>>()
    val ref = FirebaseDatabase.getInstance("https://heis-82a96-default-rtdb.asia-southeast1.firebasedatabase.app").getReference("Antrian")

    val count = MutableLiveData<Int>()

    fun setCount(newCount: Int) { count.value = newCount }

    fun add(pasien: Pasien) {
        ref.push().setValue(pasien)
    }

    fun get() = ref.orderByKey()

}