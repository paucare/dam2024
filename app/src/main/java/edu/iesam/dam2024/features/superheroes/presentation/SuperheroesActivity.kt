package edu.iesam.dam2024.features.superheroes.presentation

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.iesam.dam2024.R
import edu.iesam.dam2024.app.extensions.loadUrl
import edu.iesam.dam2024.features.movies.presentation.MovieDetailActivity
import edu.iesam.dam2024.features.movies.presentation.MovieFactory
import edu.iesam.dam2024.features.movies.presentation.MoviesViewModel
import edu.iesam.dam2024.features.superheroes.domain.Superhero

class SuperheroesActivity : AppCompatActivity() {

    private lateinit var factory : SuperheroFactory
    private lateinit var viewModel : SuperheroesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_superhero)

        factory = SuperheroFactory(this)
        //viewModel = factory.buildHeroesViewModel()
        setupObserver()

        viewModel.viewCreated()
        //Log.d("@dev","el superhero es: ${heroes.toString()}")
    }
    private fun setupObserver() {

        val heroesObserver = Observer<SuperheroesViewModel.UiState> { uiState ->
            uiState.heroes?.let {
                bindData(it)
            }
            uiState.errorApp?.let {
                //pinto el error
            }
            if (uiState.isLoading) {
                //muestro el cargando...
                Log.d("@dev", "Cargando...")
            } else {
                //oculto el cargando...
                Log.d("@dev"," Cargado ...")
            }
        }
        viewModel.uiState.observe(this, heroesObserver)
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