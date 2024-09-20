package edu.iesam.dam2024.features.data.remote

import edu.iesam.dam2024.features.domain.Movie

/*
Naming: Modelo + Tecnología + RemoteDataSource
 */
class MovieMockRemoteDataSource {
    fun getMovies(): List<Movie> = listOf(
        Movie("1","title1","poster1"),
        Movie("1","title1","poster1"),
        Movie("1","title1","poster1"),
        Movie(title="title4",poster="poster4",id="4")
    )

}