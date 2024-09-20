package edu.iesam.dam2024.features.presentation

import edu.iesam.dam2024.features.data.MovieDataRepository
import edu.iesam.dam2024.features.data.remote.MovieMockRemoteDataSource
import edu.iesam.dam2024.features.domain.GetMoviesUseCase

class MovieFactory {
    fun buildViewModel(): MovieViewModel = MovieViewModel(GetMoviesUseCase(MovieDataRepository(
        MovieMockRemoteDataSource()
    )))
}