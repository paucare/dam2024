package edu.iesam.dam2024.features.movies.presentation

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.dam2024.R
import edu.iesam.dam2024.features.movies.domain.Movie


class MovieActivity : AppCompatActivity() {

    private val movieFactory : MovieFactory = MovieFactory()
    private val viewModel = movieFactory.buildViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)
        val movies = viewModel.viewCreated()
        bindData(movies)
        viewModel.itemSelected(movies.first().id) //Simular un click sobre un item
    }
    private fun bindData(movies: List<Movie>){
        findViewById<TextView>(R.id.movie_id_1).text = movies[0].id
        findViewById<TextView>(R.id.movie_id_1).text = movies[0].title
        findViewById<LinearLayout>(R.id.layout_1).setOnClickListener {
                val movie1: Movie? = viewModel.itemSelected(movies[0].id)
                movie1?.let{
                    Log.d("@dev","Pelicula seleccionada: ${it.title}")
                }
        }

        findViewById<TextView>(R.id.movie_id_2).text = movies[1].id
        findViewById<TextView>(R.id.movie_id_2).text = movies[1].title
        findViewById<LinearLayout>(R.id.layout_2).setOnClickListener {
            val movie2: Movie? = viewModel.itemSelected(movies[1].id)
            movie2?.let{
                Log.d("@dev","Pelicula seleccionada: ${it.title}")
            }
        }

        findViewById<TextView>(R.id.movie_id_3).text = movies[2].id
        findViewById<TextView>(R.id.movie_id_3).text = movies[2].title
        findViewById<LinearLayout>(R.id.layout_3).setOnClickListener {
            val movie3: Movie? = viewModel.itemSelected(movies[2].id)
            movie3?.let{
                Log.d("@dev","Pelicula seleccionada: ${it.title}")
            }
        }

        findViewById<TextView>(R.id.movie_id_4).text = movies[3].id
        findViewById<TextView>(R.id.movie_id_4).text = movies[3].title
        findViewById<LinearLayout>(R.id.layout_4).setOnClickListener {
            val movie4: Movie? = viewModel.itemSelected(movies[3].id)
            movie4?.let{
                Log.d("@dev","Pelicula seleccionada: ${it.title}")
            }
        }

    }
}