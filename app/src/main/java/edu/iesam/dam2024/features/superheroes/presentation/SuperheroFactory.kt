package edu.iesam.dam2024.features.superheroes.presentation

import android.content.Context
import edu.iesam.dam2024.features.superheroes.data.SuperheroDataRepository
import edu.iesam.dam2024.features.superheroes.data.local.SuperheroXmlLocalDataSource
import edu.iesam.dam2024.features.superheroes.data.remote.SuperheroMockRemoteDataSource
import edu.iesam.dam2024.features.superheroes.domain.GetSuperheroUseCase
import edu.iesam.dam2024.features.superheroes.domain.GetSuperheroesUseCase

class SuperheroFactory (private val context : Context) {
    private val local = SuperheroXmlLocalDataSource(context)
    private val mockRemote = SuperheroMockRemoteDataSource()
    private val dataRepository = SuperheroDataRepository(local,mockRemote)
    private val getHeroesUseCase = GetSuperheroesUseCase(dataRepository)

    fun getSuperheroListViewModel(): SuperheroListViewModel{
        return SuperheroListViewModel(getHeroesUseCase)
    }
    fun getSuperheroDetailViewModel(): SuperheroDetailViewModel{
        return SuperheroDetailViewModel(GetSuperheroUseCase(dataRepository))
    }
  }