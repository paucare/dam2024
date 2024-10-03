package edu.iesam.dam2024.features.superheroes.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.dam2024.R
import edu.iesam.dam2024.features.movies.presentation.MovieFactory
import edu.iesam.dam2024.features.superheroes.domain.Superhero

class SuperheroesActivity : AppCompatActivity() {

    private lateinit var factory : SuperheroFactory
    private lateinit var viewModel : SuperheroesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_superhero)
        factory = SuperheroFactory(this)
        viewModel = factory.buildHeroesViewModel()

        val heroes = viewModel.viewCreated()
        //Log.d("@dev","el superhero es: ${heroes.toString()}")
    }

    private fun bindData(heroes : List<Superhero>){
        //findViewById<>()
    }
}