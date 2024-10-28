package edu.iesam.dam2024.features.superheroes.data.remote

data class SuperheroApiModel(val id: String, val name: String, val images: SuperheroImageApiModel)
data class SuperheroImageApiModel(val md: String)
