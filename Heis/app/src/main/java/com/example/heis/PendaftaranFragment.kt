package com.example.heis

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class PendaftaranFragment : Fragment(R.layout.fragment_pendaftaran) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_pendaftaran, container, false)
        view.findViewById<TextView>(R.id.text_notifications).text = "I am me"
        return view
    }
}