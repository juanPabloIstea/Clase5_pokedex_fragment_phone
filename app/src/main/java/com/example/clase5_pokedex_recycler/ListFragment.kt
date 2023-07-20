package com.example.clase5_pokedex_recycler

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.concurrent.fixedRateTimer

class ListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val myView = inflater.inflate(R.layout.fragment_list, container, false)
        recyclerView = myView.findViewById(R.id.recyclerView)
        return myView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.layoutManager = LinearLayoutManager(requireActivity())
        val adapter = PokemonAdapter()
        recyclerView.adapter = adapter
        val pokemonList = getPokemonList()

        with(adapter) {
            submitList(pokemonList)
            onItemClickListener = { pokemon ->
                navigateToDetail(pokemon)
            }
        }
    }

    private fun navigateToDetail(pokemon: Pokemon) {
        val bundle = Bundle().also {
            it.putParcelable("pokemon", pokemon)
        }

        DetailFragment().apply {
            this.arguments = bundle
        }.also {
            parentFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, it).addToBackStack(null).commit()
        }
    }

    private fun getPokemonList(): MutableList<Pokemon> {
        return mutableListOf(
            Pokemon(1, "Bulbasaur", 45, 49, 49,45, PokemonType.PLANTA, "https://www.mundodeportivo.com/alfabeta/hero/2019/09/pokemon-bulbasaur-manada.jpg?width=1200&aspect_ratio=16:9"),
            Pokemon(2, "Ivysaur",60,62,63,60,PokemonType.PLANTA,"https://www.thefactsite.com/wp-content/uploads/2019/02/ivysaur-facts.webpz"),
            Pokemon(3,"Venuasaur",80,82,83,80,PokemonType.PLANTA, "https://external-content.duckduckgo.com/iu/?u=http%3A%2F%2Ftonsoffacts.com%2Fwp-content%2Fuploads%2F2019%2F11%2F951.png&f=1&nofb=1"),
            Pokemon(4, "Charmander",39,52,43,65, PokemonType.FUEGO, "https://areajugones.sport.es/wp-content/uploads/2020/10/Charmander-Poke%CC%81mon-1080x609.jpg.webp"),
            Pokemon(5,"Charmeleon",58,64,58,80,PokemonType.FUEGO, "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fi.ytimg.com%2Fvi%2FZBIO411y9IE%2Fmaxresdefault.jpg&f=1&nofb=1"),
            Pokemon(6, "Charizzard",78,84,78,100, PokemonType.FUEGO, "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fassets.primagames.com%2Fmedia%2Fimages%2Fnews%2Fcharizard-counters-pokemon-go.jpg&f=1&nofb=1"),
            Pokemon(7,"Squirtle",44,48,46,47,PokemonType.AGUA, "https://external-content.duckduckgo.com/iu/?u=http%3A%2F%2Ftonsoffacts.com%2Fwp-content%2Fuploads%2F2019%2F11%2FTierno_Squirtle-1.png&f=1&nofb=1"),
            Pokemon(8, "Wartotle",59,63,80,58,PokemonType.AGUA, "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fi.ytimg.com%2Fvi%2F1octPQi1w4A%2Fmaxresdefault.jpg&f=1&nofb=1"),
            Pokemon(9,"Blastoise",79,84,100,78,PokemonType.AGUA, "https://external-content.duckduckgo.com/iu/?u=http%3A%2F%2Fvignette4.wikia.nocookie.net%2Fpokemon%2Fimages%2F4%2F49%2FBlue_Blastoise_Generations.png%2Frevision%2Flatest%3Fcb%3D20160923172932&f=1&nofb=1"),
            Pokemon(10,"Pikachu",35,55,40,90,PokemonType.ELECTRICO, "https://cdn.hobbyconsolas.com/sites/navi.axelspringer.es/public/media/image/2022/11/pikachu-pokemon-escarlata-purpura-2888180.jpg?tf=1200x"),
            Pokemon(11, "Raichu",60,90,110,110,PokemonType.ELECTRICO, "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fvignette.wikia.nocookie.net%2Fpokemon%2Fimages%2F4%2F4b%2FGoh_Raichu.png%2Frevision%2Flatest%3Fcb%3D20200906115835&f=1&nofb=1"),
            Pokemon(12, "Machop",70,67,76,54,PokemonType.LUCHA,"https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse1.mm.bing.net%2Fth%3Fid%3DOIP.vvI6hvzMDz5CYaYMbuG5vwHaFO%26pid%3DApi&f=1"),
            Pokemon(13,"Hitmonlee",67,54,78,65,PokemonType.LUCHA, "https://external-content.duckduckgo.com/iu/?u=http%3A%2F%2Ftonsoffacts.com%2Fwp-content%2Fuploads%2F2019%2F12%2FBarry_Hitmonlee-1180x664.png&f=1&nofb=1"),
        )
    }
}