package edu.iesam.dam2024.features.superheroes.presentation

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.iesam.dam2024.R
import edu.iesam.dam2024.app.extensions.loadUrl
import edu.iesam.dam2024.features.movies.presentation.MovieDetailActivity
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
        bindData(heroes)
    }

    private fun bindData(list : List<Superhero>){

       val recyclerView = findViewById< RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = SuperheroAdapter(list) {
            superheroId -> navigateToDetail(superheroId)
        }


    }

    private fun navigateToDetail(superheroId: String) {
        startActivity(SuperheroDetailActivity.getIntent(this,superheroId))
    }

}