package edu.iesam.dam2024.features.superheroes.presentation

import androidx.lifecycle.ViewModel
import edu.iesam.dam2024.features.superheroes.domain.GetSuperheroUseCase
import edu.iesam.dam2024.features.superheroes.domain.Superhero

class SuperheroDetailViewModel(
    private val getSuperheroUseCase: GetSuperheroUseCase
): ViewModel() {
    fun viewCreated(heroId: String): Superhero? = getSuperheroUseCase.invoke(heroId)

}