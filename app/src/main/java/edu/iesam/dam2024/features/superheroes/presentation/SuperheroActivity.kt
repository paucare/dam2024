package edu.iesam.dam2024.features.superheroes.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import edu.iesam.dam2024.R

class SuperheroActivity : AppCompatActivity() {

    private val factory : SuperheroFactory = SuperheroFactory()
    private val viewModel = factory.buildViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_superhero)
        val heroes = viewModel.viewCreated()
        Log.d("@dev","el superhero es: ${heroes.toString()}")
    }
}