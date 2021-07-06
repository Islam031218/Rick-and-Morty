package com.example.timelysoft

import com.example.timelysoft.dataClasses.Characters

interface Interface {
    fun onClickItem(position : Int, character : List<Characters>)
}