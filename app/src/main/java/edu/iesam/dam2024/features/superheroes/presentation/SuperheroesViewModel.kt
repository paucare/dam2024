package edu.iesam.dam2024.features.superheroes.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.iesam.dam2024.app.domain.ErrorApp
import edu.iesam.dam2024.features.superheroes.domain.GetSuperheroesUseCase
import edu.iesam.dam2024.features.superheroes.domain.Superhero
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SuperheroesViewModel(
    private val getSuperheroesUseCase: GetSuperheroesUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState : LiveData<UiState> = _uiState

    fun viewCreated() {
        viewModelScope.launch (Dispatchers.IO){
            val heroes = getSuperheroesUseCase.invoke()
            _uiState.postValue(UiState(heroes = heroes))
        }
    }

    data class UiState(
        val isLoading: Boolean = false,
        val errorApp: ErrorApp? = null,
        val heroes : List<Superhero>? = null
    )
}