package edu.iesam.dam2024.features.superheroes.domain

interface SuperheroRepository {
    fun findAll(): List<Superhero>

}