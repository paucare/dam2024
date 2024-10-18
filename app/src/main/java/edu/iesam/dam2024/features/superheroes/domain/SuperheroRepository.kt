package edu.iesam.dam2024.features.superheroes.domain

interface SuperheroRepository {
    suspend fun findAll(): List<Superhero>?
    fun findById(heroId : String): Superhero?
}