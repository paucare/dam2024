package edu.iesam.dam2024.features.superheroes.data.remote

import edu.iesam.dam2024.features.superheroes.domain.Appearance
import edu.iesam.dam2024.features.superheroes.domain.Biography
import edu.iesam.dam2024.features.superheroes.domain.Connections
import edu.iesam.dam2024.features.superheroes.domain.Images
import edu.iesam.dam2024.features.superheroes.domain.Powerstats
import edu.iesam.dam2024.features.superheroes.domain.Superhero
import edu.iesam.dam2024.features.superheroes.domain.Work

class SuperheroMockRemoteDataSource {

        val s = superheroBuilder()
        fun getHeroes(): List<Superhero> = listOf(s)
        //Superhero("1","title1","poster1"),

        private fun superheroBuilder(): Superhero {
        val p1 = Powerstats(1,2,3,4,5,6)
        val a1 = Appearance("a","a", listOf("a","a"),listOf("a","a"),"a","a")
        val b1 = Biography("a","a",listOf("a","a"),"a","a","a","a")
        val w1 = Work("a","a")
        val c1 = Connections("a","a")
        val i1 = Images("a","a","a","a")
        val s1 = Superhero(1,"a","a",p1,a1,b1,w1,c1,i1)
        return s1
    }
}

