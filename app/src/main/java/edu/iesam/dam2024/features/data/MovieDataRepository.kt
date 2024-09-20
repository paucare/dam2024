package edu.iesam.dam2024.features.data

import edu.iesam.dam2024.features.data.remote.MovieMockRemoteDataSource
import edu.iesam.dam2024.features.domain.Movie
import edu.iesam.dam2024.features.domain.MovieRepository

class MovieDataRepository(private val mockRemoteDataSource: MovieMockRemoteDataSource) : MovieRepository {

    override fun getMovies(): List<Movie> = mockRemoteDataSource.getMovies()
}