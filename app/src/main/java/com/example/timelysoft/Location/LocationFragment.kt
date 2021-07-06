package com.example.timelysoft.Location

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.timelysoft.R
import com.example.timelysoft.databinding.FragmentLocationBinding

class LocationFragment : Fragment() {
    private  var _binding : FragmentLocationBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLocationBinding.inflate(inflater,container,false)
        return inflater.inflate(R.layout.fragment_location, container, false)
    }

}