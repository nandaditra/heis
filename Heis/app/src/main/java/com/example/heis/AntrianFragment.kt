package com.example.heis

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class AntrianFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val antrianViewModel =
            ViewModelProvider(this).get(AntrianViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_antrian, container, false)

        val textView = root.findViewById<TextView>(R.id.text_home)

//        val pasien = Pasien("naufal", noHp="08234212389", "9824130324", 20)

        val button = root.findViewById<Button>(R.id.button)
        button.setOnClickListener {
            antrianViewModel.showList()
            antrianViewModel.antrian.observe(viewLifecycleOwner, Observer {
                for (item in it) {
                    textView.text = textView.text.toString() +  item.nama + "\n"

                }
//                antrianViewModel.add(pasien)
            })
        }

        return root
    }
}