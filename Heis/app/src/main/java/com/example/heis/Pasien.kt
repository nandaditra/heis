package com.example.heis

class Pasien(
    val nama: String = "",
    val noHp: String = "",
    val nik: String= "",
    val usia: Int = 0
) {

    var nomorAntrian: Int = 0
        get() = field
}