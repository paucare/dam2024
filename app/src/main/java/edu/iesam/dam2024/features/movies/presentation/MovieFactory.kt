package edu.iesam.dam2024.features.movies.presentation

import android.content.Context
import edu.iesam.dam2024.features.movies.data.MovieDataRepository
import edu.iesam.dam2024.features.movies.data.local.MovieXmlLocalDataSource
import edu.iesam.dam2024.features.movies.data.remote.MovieMockRemoteDataSource
import edu.iesam.dam2024.features.movies.domain.GetMovieUseCase
import edu.iesam.dam2024.features.movies.domain.GetMoviesUseCase

class MovieFactory(
    private val context : Context
) {
    val local = MovieXmlLocalDataSource(context)
    val mockRemote = MovieMockRemoteDataSource()
    val dataRepository = MovieDataRepository(mockRemote,local)
    val getMoviesUseCase = GetMoviesUseCase(dataRepository)

    fun getMovieListViewModel(): MovieListViewModel{
        return MovieListViewModel(getMoviesUseCase)
    }
    fun getMovieDetailViewModel(): MovieDetailViewModel{
        return MovieDetailViewModel(GetMovieUseCase(dataRepository))
    }



}