package com.example.timelysoft.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.timelysoft.R
import com.example.timelysoft.Retrefit.Utils
import com.example.timelysoft.dataClasses.Characters

class Adapter( list: List<Characters>
) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    init {
        Log.i("MyTag", "SearchHolder")
    }
    private var listChar = emptyList<Characters>()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        init {
            Log.i("MyTag", "Holder")
        }
        val imageAdapter: ImageView = itemView.findViewById(R.id.image_character)
        val nameAdapter: TextView = itemView.findViewById(R.id.name_character)
        val statusAdapter: TextView = itemView.findViewById(R.id.status_character)

        init {
            itemView.setOnClickListener(this)
            Log.i("MyTag","Holder2")
        }

        override fun onClick(v: View?) {
            TODO("Not yet implemented")
        }

//        override fun onClick(v: View?) {
//            listener.onClickItem(adapterPosition, listChar[adapterPosition])
//        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder:Adapter.ViewHolder, position: Int) {
        holder.itemView.apply {
            val list = listChar[position]
            holder.nameAdapter.text = list.name
            holder.statusAdapter.text = list.status
            Glide.with(context).load(Utils.IMAGE + list.image).into(holder.imageAdapter)
        }
    }

    override fun getItemCount(): Int {
        return listChar.size
    }

    fun setCharacters(characters : List<Characters>){
        listChar = characters
        notifyDataSetChanged()
    }
}