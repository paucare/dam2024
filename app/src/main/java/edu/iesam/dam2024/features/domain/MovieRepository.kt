package edu.iesam.dam2024.features.domain

interface MovieRepository {
    fun getMovies(): List<Movie>;
}