package edu.iesam.dam2024.features.movies.presentation

import android.content.Context
import edu.iesam.dam2024.features.movies.data.MovieDataRepository
import edu.iesam.dam2024.features.movies.data.local.MovieXmlLocalDataSource
import edu.iesam.dam2024.features.movies.data.remote.MovieMockRemoteDataSource
import edu.iesam.dam2024.features.movies.domain.GetMovieUseCase
import edu.iesam.dam2024.features.movies.domain.GetMoviesUseCase
import edu.iesam.dam2024.features.movies.domain.MovieRepository

class MovieFactory {

    fun buildViewModel(): MovieViewModel {
        return MovieViewModel(
        GetMoviesUseCase(MovieDataRepository(MovieMockRemoteDataSource())),
        GetMovieUseCase(MovieDataRepository(MovieMockRemoteDataSource())))
    }
}