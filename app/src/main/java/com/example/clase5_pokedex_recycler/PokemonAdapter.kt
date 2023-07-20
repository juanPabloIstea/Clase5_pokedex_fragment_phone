package com.example.clase5_pokedex_recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class PokemonAdapter: ListAdapter<Pokemon, PokemonAdapter.ViewHolder>(DiffCallBack) {

    lateinit var onItemClickListener: (Pokemon) -> Unit

    inner class ViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        private val textViewId: TextView = view.findViewById(R.id.textViewId)
        private val textViewName: TextView = view.findViewById(R.id.textViewDetailName)
        private val imageViewType: ImageView = view.findViewById(R.id.imageViewType)

        fun bind(pokemon: Pokemon) {
            textViewId.text = pokemon.id.toString()
            textViewName.text = pokemon.name

            val image = when (pokemon.type) {
                PokemonType.PLANTA -> R.drawable.planta
                PokemonType.AGUA -> R.drawable.agua
                PokemonType.ELECTRICO -> R.drawable.electrico
                PokemonType.FUEGO -> R.drawable.fuego
                else -> R.drawable.fighter
            }
            imageViewType.setImageResource(image)


            view.setOnClickListener {
                onItemClickListener(pokemon)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonAdapter.ViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonAdapter.ViewHolder, position: Int) {
        val pokemon = getItem(position)
        holder.bind(pokemon)
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<Pokemon>() {
        override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return  oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem == newItem
        }
    }
}
