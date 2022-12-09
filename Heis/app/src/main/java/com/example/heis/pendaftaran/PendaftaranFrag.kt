package com.example.heis.pendaftaran

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.heis.AntrianViewModel
import com.example.heis.MainActivity
import com.example.heis.MainActivity.Companion.NOMOR_ANTRIAN
import com.example.heis.antrian.Pasien
import com.example.heis.R

class PendaftaranFrag: Fragment() {

    val antrianVM: AntrianViewModel by activityViewModels()
    var count = 0

    private lateinit var nama: EditText
    private lateinit var nik: EditText
    private lateinit var noHp: EditText
    private lateinit var umur: EditText

    private lateinit var sp: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_pendaftaran, container, false)

        val spCheck = activity?.getSharedPreferences(MainActivity.SHARED, Context.MODE_PRIVATE)
        if (spCheck != null)
            sp = spCheck

        nama = view.findViewById(R.id.nama)
        nik = view.findViewById(R.id.NIK)
        noHp = view.findViewById(R.id.NoHp)
        umur = view.findViewById(R.id.umur)

        antrianVM.count.observe(viewLifecycleOwner, Observer {
            count = it
            Log.v("pendaftaran count", count.toString())
        })

        view.findViewById<Button>(R.id.button).setOnClickListener {
            if (nama.text.toString() == "" || nik.text.toString() == ""|| noHp.text.toString() == ""|| umur.text.toString() == "") {
                Toast.makeText(context,"Selesaikan form untuk daftar", Toast.LENGTH_SHORT).show()
            } else {
                val pasien = Pasien(nama.text.toString(), noHp.text.toString(), nik.text.toString(), umur.text.toString().toInt())
                pasien.nomorAntrian = count
                antrianVM.add(pasien)

                val editor = sp.edit()
                editor.putInt(NOMOR_ANTRIAN, pasien.nomorAntrian)
                editor.apply()

                startActivity(Intent(activity, MainActivity::class.java))
            }
        }

        return view
    }
}