package com.example.heis

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import com.example.heis.antrian.AntrianFrag
import com.example.heis.pendaftaran.PendaftaranFrag

class MainActivity : AppCompatActivity() {

    val antrianVM: AntrianViewModel by viewModels()

    private lateinit var sp: SharedPreferences

    companion object {
        val SHARED = "KeyShared"
        val NOMOR_ANTRIAN = "NOMOR_ANTRIAN"
        val PASIEN = "PASIEN"
        val TOP_NUMBER = "TOP_NUMBER"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spCheck = getSharedPreferences(SHARED, MODE_PRIVATE)
        if (spCheck != null) {
            sp = spCheck
        }
        val res = sp.getInt(NOMOR_ANTRIAN, 0)
        Log.v("shared", res.toString())

        val frag_pendaftaran = PendaftaranFrag()
        val frag_antrian = AntrianFrag()

        antrianVM.count.observe(this) {
            Log.v("main activity count", it.toString())
        }

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout, frag_antrian)
            commit()
        }

        findViewById<BottomNavigationView>(R.id.bottomNavigationView).setOnNavigationItemSelectedListener  {
            when(it.itemId) {
                R.id.navigation_pendaftaran-> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.frameLayout, frag_pendaftaran)
                        commit()
                    }
                }
                R.id.navigation_antrian-> {
                    supportFragmentManager.beginTransaction().apply {
                        replace(R.id.frameLayout, frag_antrian)
                        commit()
                    }
                }
            }
            true
        }
    }
}