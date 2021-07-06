package com.example.timelysoft.Character

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.timelysoft.Adapter.Adapter
import com.example.timelysoft.R
import com.example.timelysoft.dataClasses.Characters
import com.example.timelysoft.databinding.FragmentCharacterBinding

class CharacterFragment : Fragment() {

    init {
        Log.i("MyTag","initCharacter")
    }
    private lateinit var adapter: Adapter
    private var _binding: FragmentCharacterBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: CharacterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCharacterBinding.inflate(inflater, container, false)
        return inflater.inflate(R.layout.fragment_character, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i("MyTag","CharacterFragment")
        viewModel = ViewModelProvider(this).get(CharacterViewModel :: class.java)
        viewModel.liveDataSearchCharacters.observe(viewLifecycleOwner, {
            configureRecyclerView(it.results, binding.recyclerView)

        })
    }

    private fun configureRecyclerView(list: List<Characters>, layout: RecyclerView) {
        layout.layoutManager = LinearLayoutManager(
            view?.context,
            LinearLayoutManager.HORIZONTAL, false
        )
        adapter = Adapter(list)
        layout.adapter = adapter

    }

}
