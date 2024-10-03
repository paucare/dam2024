package edu.iesam.dam2024.features.superheroes.domain

class GetSuperheroUseCase(private val heroRepository: SuperheroRepository){
    operator fun invoke(heroId : String): Superhero? = heroRepository.findById(heroId)
}