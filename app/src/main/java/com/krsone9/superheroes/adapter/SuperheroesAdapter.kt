package com.krsone9.superheroes.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.krsone9.superheroes.R
import com.krsone9.superheroes.data.Superheroe
import com.krsone9.superheroes.utils.SuperheroesViewHolder

class SuperheroesAdapter(
    var superheroeList: List<Superheroe> = emptyList()
) :
    RecyclerView.Adapter<SuperheroesViewHolder>() {

    fun updateList(superheroeList: List<Superheroe>) {
        this.superheroeList = superheroeList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroesViewHolder {
        return SuperheroesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_superheroe, parent, false)
        )
    }

    override fun getItemCount() = superheroeList.size


    override fun onBindViewHolder(viewholder: SuperheroesViewHolder, position: Int) {
        viewholder.bind(superheroeList[position])
    }
}
