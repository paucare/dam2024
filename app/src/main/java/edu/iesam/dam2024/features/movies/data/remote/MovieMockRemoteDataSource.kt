package edu.iesam.dam2024.features.movies.data.remote

import edu.iesam.dam2024.features.movies.domain.Movie

/*
Naming: Modelo + Tecnología + RemoteDataSource
 */
class MovieMockRemoteDataSource {

    fun getMovies(): List<Movie> = listOf(
        Movie("1","Parasyte","https://pics.filmaffinity.com/gisaengchung-432616131-large.jpg"),
        Movie("2","L'Haine","poster2"),
        Movie("3","Mad Max","poster3"),
        Movie(title="Paddington",poster="poster4",id="4")
    )

    fun getMovie(movieId : String): Movie? {
        //it es un objeto movie del listado
        return getMovies().firstOrNull { it.id == movieId}
        //movie -> RENOMBRO EL IT POR MOVIE movie.id === movieId
    }

    /*
    fun getMovie(movieId: String): Movie? {
        return movies.firstOrNull { movie ->  movie.id == movieId
        }
    }
     */
}

