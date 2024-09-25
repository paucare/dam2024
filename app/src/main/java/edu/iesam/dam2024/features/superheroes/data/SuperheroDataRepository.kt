package edu.iesam.dam2024.features.superheroes.data

import edu.iesam.dam2024.features.superheroes.data.remote.SuperheroMockRemoteDataSource
import edu.iesam.dam2024.features.superheroes.domain.Superhero
import edu.iesam.dam2024.features.superheroes.domain.SuperheroRepository

class SuperheroDataRepository(private val mockRemote: SuperheroMockRemoteDataSource) : SuperheroRepository {
    override fun findAll(): List<Superhero> = mockRemote.getHeroes()
}