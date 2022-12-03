package com.example.heis

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import com.example.heis.antrian.AntrianFrag

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val frag_pendaftaran = PendaftaranFrag()
        val frag_antrian = AntrianFrag()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout, frag_antrian)
            commit()
        }

        findViewById<BottomNavigationView>(R.id.bottomNavigationView).setOnNavigationItemSelectedListener  {
            when(it.itemId) {
                R.id.navigation_pendaftaran->supportFragmentManager.beginTransaction().apply {
                    replace(R.id.frameLayout, frag_pendaftaran)
                    commit()
                }
                R.id.navigation_antrian->supportFragmentManager.beginTransaction().apply {
                    replace(R.id.frameLayout, frag_antrian)
                    commit()
                }
            }
            true
        }
    }
}