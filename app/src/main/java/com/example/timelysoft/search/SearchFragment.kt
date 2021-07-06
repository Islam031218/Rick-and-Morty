package com.example.timelysoft.search

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.timelysoft.Adapter.Adapter
import com.example.timelysoft.Character.CharacterViewModel
import com.example.timelysoft.Interface
import com.example.timelysoft.R
import com.example.timelysoft.dataClasses.Characters
import com.example.timelysoft.databinding.FragmentSearchBinding

class SearchFragment : Fragment(), Interface {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: CharacterViewModel
    lateinit var adapterSearch : Adapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i("MyTag","SearchFragment")
        binding.apply {

            filterButton.setOnClickListener{
                Log.i("MyTag", "buttonClicked")
                findNavController().navigate(R.id.filterFragment)
            }
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String?): Boolean {
                    viewModel.getByName(query.toString())
                    viewModel.liveDataSearchCharacters.observe(viewLifecycleOwner,{characterList ->
                        configureRecyclerView(characterList.results)
                    })
                    searchView.setQuery("",false)
                    searchView.clearFocus()
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    return false
                }

            })
        }

    }

    private fun configureRecyclerView(list: List<Characters>){
        binding.apply {
            searchRecyclerView.layoutManager = LinearLayoutManager(context,
                LinearLayoutManager.VERTICAL,false)
//            adapterSearch = Adapter()
            searchRecyclerView.adapter = adapterSearch
        }

    }


    override fun onClickItem(position: Int, character: List<Characters>) {
        TODO("Not yet implemented")
    }


}