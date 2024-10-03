package edu.iesam.dam2024.features.superheroes.presentation

import androidx.lifecycle.ViewModel
import edu.iesam.dam2024.features.superheroes.domain.GetSuperheroesUseCase
import edu.iesam.dam2024.features.superheroes.domain.Superhero

class SuperheroesViewModel(
    private val getSuperheroesUseCase: GetSuperheroesUseCase
) : ViewModel() {

    fun viewCreated() : List<Superhero> = getSuperheroesUseCase.invoke()
}