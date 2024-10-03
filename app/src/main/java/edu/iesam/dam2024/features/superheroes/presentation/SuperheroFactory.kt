package edu.iesam.dam2024.features.superheroes.presentation

import android.content.Context
import edu.iesam.dam2024.features.superheroes.data.SuperheroDataRepository
import edu.iesam.dam2024.features.superheroes.data.remote.SuperheroMockRemoteDataSource
import edu.iesam.dam2024.features.superheroes.domain.GetSuperheroesUseCase

class SuperheroFactory (private val context : Context) {

    private val mockRemote = SuperheroMockRemoteDataSource()
    private val dataRepository = SuperheroDataRepository(mockRemote)
    private val getHeroesUseCase = GetSuperheroesUseCase(dataRepository)
    private val getHeroUseCase = GetSuperheroesUseCase(dataRepository)

    fun buildHeroesViewModel(): SuperheroesViewModel {
        return SuperheroesViewModel(getHeroesUseCase)
    }
}