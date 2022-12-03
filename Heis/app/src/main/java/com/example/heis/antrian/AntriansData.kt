package com.example.heis.antrian

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

    private var noAntrianPasien = arrayOf("111G47",
        "111G48",
        "111G49",
        "111G50",
        "111G51",
        "111G52",
        "111G53",
        "111G54",
        "111G55",
        "111G56",
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
                antrian.noAntrian = noAntrianPasien[position]
                listAntrian.add(antrian)
            }
            return listAntrian
        }
}