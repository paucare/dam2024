package edu.iesam.dam2024.features.presentation

import androidx.lifecycle.ViewModel
import edu.iesam.dam2024.features.domain.GetMoviesUseCase
import edu.iesam.dam2024.features.domain.Movie

class MovieViewModel(private val getMoviesUseCase: GetMoviesUseCase) : ViewModel() {

    fun viewCreated(): List<Movie> = getMoviesUseCase.invoke()
}