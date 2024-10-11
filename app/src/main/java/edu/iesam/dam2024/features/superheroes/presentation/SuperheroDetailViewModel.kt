package edu.iesam.dam2024.features.superheroes.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.dam2024.app.domain.ErrorApp
import edu.iesam.dam2024.features.movies.domain.Movie
import edu.iesam.dam2024.features.superheroes.domain.GetSuperheroUseCase
import edu.iesam.dam2024.features.superheroes.domain.Superhero
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SuperheroDetailViewModel(
    private val getSuperheroUseCase: GetSuperheroUseCase
): ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState : LiveData<UiState> = _uiState

    fun viewCreated(superheroId : String){
        viewModelScope.launch(Dispatchers.IO) {
            val hero = getSuperheroUseCase.invoke(superheroId)
            _uiState.postValue(UiState(superhero = hero))

        }
    }

    data class UiState(
        val isLoading: Boolean = false,
        val errorApp: ErrorApp? = null,
        val superhero : Superhero? = null
    )
}