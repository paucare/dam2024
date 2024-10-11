package edu.iesam.dam2024.features.superheroes.data

import edu.iesam.dam2024.features.superheroes.data.local.SuperheroXmlLocalDataSource
import edu.iesam.dam2024.features.superheroes.data.remote.SuperheroMockRemoteDataSource
import edu.iesam.dam2024.features.superheroes.domain.Superhero
import edu.iesam.dam2024.features.superheroes.domain.SuperheroRepository

class SuperheroDataRepository(
    private val local : SuperheroXmlLocalDataSource,
    private val mockRemote: SuperheroMockRemoteDataSource
) :
    SuperheroRepository {

    override fun findAll(): List<Superhero> {
        val heroesFromLocal = local.findAll()
        if(heroesFromLocal.isEmpty()){
            val heroesFromRemote = mockRemote.getHeroes()
            local.saveAll(heroesFromRemote)
            return heroesFromRemote
        } else {
            return heroesFromLocal
        }
    }
    override fun findById(heroId : String): Superhero? {
        val localHero = local.findById(heroId)
        if(localHero == null){
            mockRemote.getSingleHero(heroId)?.let {
                local.save(it)
                return it
            }
        }
        return localHero
    }
}