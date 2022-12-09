package com.example.heis.antrian

import android.os.Parcel
import android.os.Parcelable

data class Pasien(
    val nama: String = "",
    val noHp: String = "",
    val nik: String= "",
    val usia: Int = 0,
    var nomorAntrian: Int = 0
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nama)
        parcel.writeString(noHp)
        parcel.writeString(nik)
        parcel.writeInt(usia)
        parcel.writeInt(nomorAntrian)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Pasien> {
        override fun createFromParcel(parcel: Parcel): Pasien {
            return Pasien(parcel)
        }

        override fun newArray(size: Int): Array<Pasien?> {
            return arrayOfNulls(size)
        }
    }
}