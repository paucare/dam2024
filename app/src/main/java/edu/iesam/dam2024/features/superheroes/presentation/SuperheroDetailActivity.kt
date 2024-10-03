package edu.iesam.dam2024.features.superheroes.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import edu.iesam.dam2024.R
import edu.iesam.dam2024.app.extensions.loadUrl
import edu.iesam.dam2024.features.movies.presentation.MovieDetailActivity
import edu.iesam.dam2024.features.superheroes.domain.Superhero

class SuperheroDetailActivity : AppCompatActivity() {
    private lateinit var factory: SuperheroFactory
    private lateinit var  viewModel: SuperheroDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_superhero_detail)

        factory = SuperheroFactory(this)
        viewModel = factory.buildHeroDetailViewModel()

        getSuperheroId()?.let{ heroId->
            viewModel.viewCreated(heroId)?.let { hero ->
                bindData(hero)
            }
        }


    }

    private fun getSuperheroId(): String? {
        return intent.getStringExtra(KEY_HERO_ID)

    }
    private fun bindData(item : Superhero){
        val imageView = findViewById<ImageView>(R.id.superheroImage)
        imageView.loadUrl(item.images.sm)
        findViewById<TextView>(R.id.superheroName).text = item.name
        findViewById<TextView>(R.id.biography).text = item.biography.toString()
        findViewById<TextView>(R.id.connections).text = item.connections.toString()
    }
    companion object{
        val KEY_HERO_ID = "key_superhero_id"

        fun getIntent(context: Context, heroId : String): Intent {
            val intent = Intent(context, SuperheroDetailActivity::class.java)
            intent.putExtra(KEY_HERO_ID,heroId)
            return intent
        }
    }


}




