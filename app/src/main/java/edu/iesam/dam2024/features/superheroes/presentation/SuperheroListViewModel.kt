package edu.iesam.dam2024.features.superheroes.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.dam2024.app.domain.ErrorApp
import edu.iesam.dam2024.features.superheroes.domain.GetSuperheroesUseCase
import edu.iesam.dam2024.features.superheroes.domain.Superhero
import kotlinx.coroutines.launch
import kotlinx.coroutines.Dispatchers


class SuperheroListViewModel(
    private val getSuperheroesUseCase: GetSuperheroesUseCase
): ViewModel() {
    private val _uiState = MutableLiveData<UiState>()
    val uiState : LiveData<UiState> = _uiState
    fun loadSuperHeroes(){
        viewModelScope.launch(Dispatchers.IO){
            val superheroes = getSuperheroesUseCase.invoke()
            _uiState.postValue(UiState(superheroes = superheroes))
        }
    }

    data class UiState(
        var isloading: Boolean = false,
        var errorApp: ErrorApp? = null,
        var superheroes: List<Superhero>? = null
    )
}