package edu.iesam.dam2024.features.movies.presentation

import edu.iesam.dam2024.features.movies.data.MovieDataRepository
import edu.iesam.dam2024.features.movies.data.remote.MovieMockRemoteDataSource
import edu.iesam.dam2024.features.movies.domain.GetMoviesUseCase

class MovieFactory {
    fun buildViewModel(): MovieViewModel = MovieViewModel(
        GetMoviesUseCase(
        MovieDataRepository(
        MovieMockRemoteDataSource()
    )
    )
    )
}