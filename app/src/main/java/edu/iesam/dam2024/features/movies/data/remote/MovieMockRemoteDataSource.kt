package edu.iesam.dam2024.features.movies.data.remote

import edu.iesam.dam2024.features.movies.domain.Movie

/*
Naming: Modelo + Tecnología + RemoteDataSource
 */
class MovieMockRemoteDataSource {

    fun getMovies(): List<Movie> = listOf(
        Movie("1","Parasite","https://pics.filmaffinity.com/gisaengchung-432616131-large.jpg"),
        Movie("2","La Haine","https://pics.filmaffinity.com/la_haine_hate-391751524-large.jpg"),
        Movie("3","Mad Max: Fury Road","https://pics.filmaffinity.com/mad_max_fury_road-429261909-large.jpg"),
        Movie(title="Paddington in Peru",poster="https://pics.filmaffinity.com/paddington_in_peru-611269354-large.jpg",id="4"),
        Movie("4","Pom Poko","https://pics.filmaffinity.com/heisei_tanuki_gassen_ponpoko-405273104-large.jpg"),
        Movie("5","The Lighthouse","https://pics.filmaffinity.com/the_lighthouse-929309607-large.jpg"),
        Movie("6","Fallen Angels","https://pics.filmaffinity.com/duo_luo_tian_shi_fallen_angels-941092251-large.jpg"),
        Movie("7","Pride & Prejudice","https://pics.filmaffinity.com/pride_and_prejudice-629327318-large.jpg")

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

