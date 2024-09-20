package edu.iesam.dam2024.features.domain

class GetMoviesUseCase(private val movieRepository: MovieRepository) {

    operator fun invoke(): List<Movie> = movieRepository.getMovies()
}