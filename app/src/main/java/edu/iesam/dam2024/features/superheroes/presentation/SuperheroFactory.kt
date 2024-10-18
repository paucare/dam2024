package edu.iesam.dam2024.features.superheroes.presentation

import android.content.Context
import edu.iesam.dam2024.app.data.ApiClient
import edu.iesam.dam2024.features.superheroes.data.SuperheroDataRepository
import edu.iesam.dam2024.features.superheroes.data.local.SuperheroXmlLocalDataSource
import edu.iesam.dam2024.features.superheroes.data.remote.SuperheroApiRemoteDataSource
import edu.iesam.dam2024.features.superheroes.data.remote.SuperheroMockRemoteDataSource
import edu.iesam.dam2024.features.superheroes.domain.GetSuperheroUseCase
import edu.iesam.dam2024.features.superheroes.domain.GetSuperheroesUseCase

class SuperheroFactory (private val context : Context) {
    private val local = SuperheroXmlLocalDataSource(context)
    private val dataRepository = SuperheroDataRepository(local,getRemoteDataSource())
    private val getHeroesUseCase = GetSuperheroesUseCase(dataRepository)

    fun getSuperheroListViewModel(): SuperheroListViewModel{
        return SuperheroListViewModel(getHeroesUseCase)
    }
    fun getSuperheroDetailViewModel(): SuperheroDetailViewModel{
        return SuperheroDetailViewModel(GetSuperheroUseCase(dataRepository))
    }
    private fun getRemoteDataSource(): SuperheroApiRemoteDataSource {
        val superheroService = ApiClient.provideSuperheroService()
        return SuperheroApiRemoteDataSource(superheroService)
    }

  }