package com.example.clase5_pokedex_recycler

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

class DetailFragment : Fragment() {

    private lateinit var ataqueTextView: TextView
    private lateinit var defensaTextView: TextView
    private lateinit var velocidadTextView: TextView
    private lateinit var vidaTextView: TextView
    private lateinit var imageView: ImageView
    private lateinit var progressBar: ProgressBar
    private lateinit var pokemon: Pokemon

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { bundle->
            pokemon = bundle.getParcelable("pokemon")!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val myView = inflater.inflate(R.layout.fragment_detail, container, false)
        ataqueTextView = myView.findViewById(R.id.textViewAtaque)
        defensaTextView = myView.findViewById(R.id.textViewDefensa)
        velocidadTextView = myView.findViewById(R.id.textViewVelocity)
        vidaTextView = myView.findViewById(R.id.textViewVida)
        imageView = myView.findViewById(R.id.imageView)
        progressBar = myView.findViewById(R.id.progressBar)
        return myView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        progressBar.visibility = View.VISIBLE

        Glide.with(this).load(pokemon.url).listener(object :RequestListener<Drawable>{
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {
                progressBar.visibility = View.INVISIBLE
                imageView.setImageResource(R.drawable.pokemon)
                return false
            }

            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: Target<Drawable>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                progressBar.visibility = View.INVISIBLE
                return false
            }
        }).into(imageView)

        ataqueTextView.text = "Atq: ${pokemon.attack}"
        defensaTextView.text = "Def: ${pokemon.defense}"
        velocidadTextView.text = "Vel: ${pokemon.speed}"
        vidaTextView.text = "Vida: ${pokemon.life}"

    }
}