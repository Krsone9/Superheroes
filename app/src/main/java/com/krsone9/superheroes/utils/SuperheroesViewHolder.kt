package com.krsone9.superheroes.utils

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.krsone9.superheroes.data.Superheroe
import com.krsone9.superheroes.databinding.ItemSuperheroeBinding

class SuperheroesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemSuperheroeBinding.bind(view)
    fun bind(superheroesResponse: Superheroe) {
        binding.tvSuperheroName.text = superheroesResponse.name

    }
}