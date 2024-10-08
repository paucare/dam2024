package edu.iesam.dam2024.features.movies.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import edu.iesam.dam2024.R
import edu.iesam.dam2024.app.extensions.loadUrl
import edu.iesam.dam2024.features.movies.domain.Movie

class MovieDetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        movieFactory = MovieFactory(this)
        viewModel = movieFactory.buildMovieDetailViewModel()
        setupObserver()

        getMovieId()?.let { movieId ->
            viewModel.viewCreated(movieId)
        }

    }

    private fun getMovieId() : String? {
        return intent.getStringExtra(KEY_MOVIE_ID)
    }

    companion object {
        val KEY_MOVIE_ID = "key_movie_id"

        fun getIntent(context: Context,movieId : String): Intent {
                    val intent = Intent(context,MovieDetailActivity::class.java)
                    intent.putExtra(KEY_MOVIE_ID,movieId)
                    return intent
        }
    }
}