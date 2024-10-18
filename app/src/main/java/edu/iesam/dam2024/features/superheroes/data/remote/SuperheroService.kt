package edu.iesam.dam2024.features.superheroes.data.remote

import edu.iesam.dam2024.features.superheroes.domain.Superhero
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SuperheroService {

    // REST API: POST, GET, DELETE, PUT, PATCH

    @GET("all.json")
    suspend fun requestSuperheroes(): Response<List<Superhero>>

    @GET("id/{heroId}.json")
    suspend fun requestSingleHero(@Path("heroId") heroId : String): Response<Superhero>
}