package edu.iesam.dam2024.features.superheroes.domain

interface SuperheroRepository {
    fun getHeroes(): List<Superhero>

}