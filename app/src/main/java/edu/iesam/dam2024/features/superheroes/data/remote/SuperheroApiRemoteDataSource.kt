package edu.iesam.dam2024.features.superheroes.data.remote

import edu.iesam.dam2024.features.superheroes.domain.Superhero

class SuperheroApiRemoteDataSource(
    private val superheroService: SuperheroService
) {

    suspend fun getSuperheroes(): List<Superhero>? {

    return superheroService.requestSuperheroes().body()

    }




}