package com.example.heis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.heis.antrian.Pasien

class SecondActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val pasien = intent.extras?.getParcelable(MainActivity.PASIEN) as Pasien?
        val top_number = intent.extras?.getInt(MainActivity.TOP_NUMBER) ?:0

        findViewById<TextView>(R.id.item_tv_nomor).text = pasien?.nomorAntrian.toString()
        findViewById<TextView>(R.id.item_tv_nama).text = pasien?.nama
        findViewById<TextView>(R.id.item_tv_noHp).text = pasien?.noHp
        findViewById<TextView>(R.id.item_tv_nik).text = pasien?.nik
        findViewById<TextView>(R.id.item_tv_umur).text = pasien?.usia.toString()
        findViewById<TextView>(R.id.item_tv_sisa_antrian).text = (pasien?.nomorAntrian?.minus(
            top_number
        )).toString()
    }
}