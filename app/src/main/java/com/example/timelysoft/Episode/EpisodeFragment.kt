package com.example.timelysoft.Episode

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.timelysoft.R
import com.example.timelysoft.databinding.FragmentCharacterBinding
import com.example.timelysoft.databinding.FragmentEpisodeBinding

class EpisodeFragment : Fragment() {
    private var _binding: FragmentEpisodeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEpisodeBinding.inflate(layoutInflater, container, false)
        return inflater.inflate(R.layout.fragment_episode, container, false)
    }

}