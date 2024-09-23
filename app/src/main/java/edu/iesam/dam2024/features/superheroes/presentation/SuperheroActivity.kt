package edu.iesam.dam2024.features.superheroes.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import edu.iesam.dam2024.R

class SuperheroActivity : AppCompatActivity() {

    private val factory : SuperheroFactory = SuperheroFactory()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel = factory.buildViewModel()
        val heroes = viewModel.viewCreated()
        //Log.d("@dev",heroes.toString())
        Log.d("@dev","Hola")
    }
}