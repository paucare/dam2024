package edu.iesam.dam2024.features.movies.data

import edu.iesam.dam2024.features.movies.data.remote.MovieMockRemoteDataSource
import edu.iesam.dam2024.features.movies.domain.Movie
import edu.iesam.dam2024.features.movies.domain.MovieRepository

class MovieDataRepository(private val mockRemoteDataSource: MovieMockRemoteDataSource) :
    MovieRepository {

    override fun getMovies(): List<Movie> = mockRemoteDataSource.getMovies()
    override fun getMovie(movieId : String): Movie? = mockRemoteDataSource.getMovie(movieId)
}