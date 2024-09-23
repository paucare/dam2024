package edu.iesam.dam2024.features.movies.domain

import edu.iesam.dam2024.features.movies.data.remote.MovieMockRemoteDataSource

class GetMovieUseCase(private val movieRepository: MovieRepository){
    operator fun invoke(movieId : String): Movie? = movieRepository.getMovie(movieId)
}