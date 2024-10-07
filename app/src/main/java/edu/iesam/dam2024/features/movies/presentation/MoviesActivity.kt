package edu.iesam.dam2024.features.movies.presentation

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import edu.iesam.dam2024.R
import edu.iesam.dam2024.app.domain.ErrorApp
import edu.iesam.dam2024.features.movies.data.local.MovieXmlLocalDataSource
import edu.iesam.dam2024.features.movies.domain.Movie


class MoviesActivity : AppCompatActivity() {

    //No es muy buena practica lateinit
    private lateinit var movieFactory : MovieFactory
    private lateinit var viewModel : MoviesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)

        movieFactory = MovieFactory(this)
        viewModel = movieFactory.buildViewModel()

        setupObserver()

        viewModel.viewCreated()

        /*
        val movies = viewModel.viewCreated()
        bindData(movies)
         */
        //viewModel.itemSelected(movies.first().id) //Simular un click sobre un item
    }
    private fun setupObserver() {

        val movieObserver = Observer<MoviesViewModel.UiState> { uiState ->
            uiState.movies?.let {
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
        viewModel.uiState.observe(this, movieObserver)
    }

         fun bindData(movies: List<Movie>){
        findViewById<TextView>(R.id.movie_id_1).text = movies[0].id
        findViewById<TextView>(R.id.movie_id_1).text = movies[0].title
        findViewById<LinearLayout>(R.id.layout_1).setOnClickListener {
              navigateToDetail(movies[0].id)
        }

        findViewById<TextView>(R.id.movie_id_2).text = movies[1].id
        findViewById<TextView>(R.id.movie_id_2).text = movies[1].title
        findViewById<LinearLayout>(R.id.layout_2).setOnClickListener {
            navigateToDetail(movies[1].id)
        }

        findViewById<TextView>(R.id.movie_id_3).text = movies[2].id
        findViewById<TextView>(R.id.movie_id_3).text = movies[2].title
        findViewById<LinearLayout>(R.id.layout_3).setOnClickListener {
            navigateToDetail(movies[2].id)
        }

        findViewById<TextView>(R.id.movie_id_4).text = movies[3].id
        findViewById<TextView>(R.id.movie_id_4).text = movies[3].title
        findViewById<LinearLayout>(R.id.layout_4).setOnClickListener {
            navigateToDetail(movies[3].id)
        }

    }

    private fun navigateToDetail(movieId : String) {
        //val intent = Intent(this,MovieDetailActivity::class.java)
        startActivity(MovieDetailActivity.getIntent(this,movieId))
    }
    private fun showError(error : ErrorApp){
        when(error){
            ErrorApp.InternetErrorApp -> TODO()
            ErrorApp.ServerErrorApp-> TODO()
            ErrorApp.DataErrorApp -> TODO()
            ErrorApp.UnkownErrorApp -> TODO()
        }
    }
}