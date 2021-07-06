package com.example.timelysoft.Datail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.timelysoft.R
import com.example.timelysoft.Retrefit.Utils
import com.example.timelysoft.dataClasses.Characters
import com.example.timelysoft.databinding.FragmentDatailsBinding

class DatailsFragment : Fragment() {
    private var _binding: FragmentDatailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDatailsBinding.inflate(inflater,container,false)
        return inflater.inflate(R.layout.fragment_datails, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle = this.arguments
        val character = bundle?.getSerializable("character") as Characters

        binding.apply {
            nameDes.text = character.name
            statusDes.text = character.status
            specieDes.text = character.species
            genderDes.text = character.gender
            originDes.text = character.origin.name
            locationDes.text = character.location.name
            episodeDes.text = character.episode.get(0)
            Glide.with(this@DatailsFragment).load(Utils.IMAGE+character.image).into(imageDes)


        }
    }


}