package edu.iesam.dam2024.features.superheroes.domain

import edu.iesam.dam2024.features.movies.domain.Movie

class GetSuperheroesUseCase(private val repository: SuperheroRepository) {
    operator fun invoke(): List<Superhero> = repository.findAll()

}