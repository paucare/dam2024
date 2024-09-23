package edu.iesam.dam2024.features.movies.data.remote

import edu.iesam.dam2024.features.movies.domain.Movie

/*
Naming: Modelo + Tecnología + RemoteDataSource
 */
class MovieMockRemoteDataSource {
    fun getMovies(): List<Movie> = listOf(
        Movie("1","title1","poster1"),
        Movie("2","title2","poster2"),
        Movie("3","title3","poster3"),
        Movie(title="title4",poster="poster4",id="4")
    )

    fun getMovie(movieId : String): Movie? {
        //it es un objeto movie del listado
        return getMovies().firstOrNull { it.id == movieId}
        //movie -> RENOMBRO EL IT POR MOVIE movie.id === movieId
    }
}

