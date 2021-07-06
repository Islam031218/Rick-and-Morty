package com.example.timelysoft

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.timelysoft.databinding.FragmentFiltrBinding

class filtrFragment : Fragment() {
    private var _binding : FragmentFiltrBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFiltrBinding.inflate(inflater,container,false)
        return inflater.inflate(R.layout.fragment_filtr, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.filterFragment.setOnClickListener {
            Log.i("MyTag","filtrClick")
            findNavController().popBackStack(R.id.filtrFragment,false)
        }
    }


}