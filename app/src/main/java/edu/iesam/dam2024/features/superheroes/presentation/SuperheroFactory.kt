package edu.iesam.dam2024.features.superheroes.presentation

import edu.iesam.dam2024.features.movies.domain.GetMoviesUseCase
import edu.iesam.dam2024.features.superheroes.data.SuperheroDataRepository
import edu.iesam.dam2024.features.superheroes.data.remote.SuperheroMockRemoteDataSource
import edu.iesam.dam2024.features.superheroes.domain.GetSuperheroesUseCase

class SuperheroFactory {

    fun buildViewModel(): SuperheroViewModel = SuperheroViewModel(
        GetSuperheroesUseCase(
            SuperheroDataRepository(
                SuperheroMockRemoteDataSource()
            )))
}