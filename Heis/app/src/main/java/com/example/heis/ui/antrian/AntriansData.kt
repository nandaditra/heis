package com.example.heis.ui.antrian

object AntriansData {
    private var namaPasien = arrayOf("Naufal Fathurahman Mahing",
    "Roid Muhammad",
    "Ramadhani Rachman",
    "Nanda Aditya Putra",
    "Samuel Marolop",
    "Muhammad Alifyan",
    "Ahmad Zuhal",
    "Syarli Nur",
    "Qolandar Annuri",
    "Sholeh Al Farys")

    private var noHpPasien = arrayOf("082364838483",
        "082364838483",
        "082364838483",
        "082364838483",
        "082364838483",
        "082364838483",
        "082364838483",
        "082364838483",
        "082364838483",
        "082364838483"
    )

    private var ktpPasien = arrayOf("332502843483593",
        "332502843483593",
        "332502843483593",
        "332502843483593",
        "332502843483593",
        "332502843483593",
        "332502843483593",
        "332502843483593",
        "332502843483593",
        "332502843483593"
    )

    private var usiaPasien = arrayOf(20,20,20,20,20,20,20,20,20,20)

    val listData: ArrayList<Antrian>
        get() {
            val listAntrian = arrayListOf<Antrian>()

            for(position in namaPasien.indices) {
                val antrian = Antrian()
                antrian.nama = namaPasien[position]
                antrian.noHp = noHpPasien[position]
                antrian.ktp = ktpPasien[position]
                antrian.usia = usiaPasien[position]
                listAntrian.add(antrian)
            }
            return listAntrian
        }
}