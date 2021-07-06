@file:Suppress("UnusedImport")

package com.example.timelysoft

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.timelysoft.Character.CharacterFragment
import com.example.timelysoft.Episode.EpisodeFragment
import com.example.timelysoft.Location.LocationFragment
import com.example.timelysoft.databinding.ActivityMainBinding
import com.example.timelysoft.search.SearchFragment


class MainActivity : AppCompatActivity() {
    private  var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        setFragmentContainer(CharacterFragment())
        setSupportActionBar(binding!!.toolbar)
        Log.i("MyTag", "inMain")
        binding!!.bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.character -> setFragmentContainer(CharacterFragment())
                R.id.location -> setFragmentContainer(LocationFragment())
                R.id.search -> setFragmentContainer(SearchFragment())
                R.id.episode -> setFragmentContainer(EpisodeFragment());
            }
            true
        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.toolbar -> setFragmentContainer(CharacterFragment())
        }
        return super.onOptionsItemSelected(item)
    }
    private fun setFragmentContainer(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            commit()
        }
    }
}