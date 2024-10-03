package edu.iesam.dam2024.features.superheroes.data.remote

import edu.iesam.dam2024.features.superheroes.domain.Appearance
import edu.iesam.dam2024.features.superheroes.domain.Biography
import edu.iesam.dam2024.features.superheroes.domain.Connections
import edu.iesam.dam2024.features.superheroes.domain.Images
import edu.iesam.dam2024.features.superheroes.domain.Powerstats
import edu.iesam.dam2024.features.superheroes.domain.Superhero
import edu.iesam.dam2024.features.superheroes.domain.Work
//Naming: Modelo + Tecnología + RemoteDataSource
class SuperheroMockRemoteDataSource {

        val p1 = Powerstats(90,55,3,67,74,85)
        val a1 = Appearance("Male","Human", listOf("5 10","178"),listOf("165","74"),"Hazel","Brown")
        val b1 = Biography("Peter Parker","No alter egos found",listOf("Bag-man","Spider-Boy"),"New York,New York","Amazing Fantasy #15","Marvel Comics","Good")
        val w1 = Work("Freelance photographer","New York")
        val c1 = Connections("Avengers","May Parker")
        val i1 = Images(
                "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/xs/620-spider-man.jpg",
                "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/sm/620-spider-man.jpg",
                "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/md/620-spider-man.jpg",
                "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/lg/620-spider-man.jpg"
        )
        val s1 = Superhero("1","Spider-man","620-spider-man",p1,a1,b1,w1,c1,i1)

        val p2 = Powerstats(88, 10, 27, 85, 93, 56)
        val a2 = Appearance("Female", "Human ", listOf("5'6", "168 cm"), listOf("120 lb", "54 kg"), "Blue", "Blond")
        val b2 = Biography("Susan Storm Richards", "No alter egos found.", listOf("Invisible Girl"), "Glenville, Long Island, New York", "FANTASTIC FOUR #1", "Marvel Comics", "Good")
        val w2 = Work("Member of the Fantastic Four", "Pier Four, New York City")
        val c2 = Connections("Fantastic Four", "Johnny Storm")
        val i2 = Images(
                "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/xs/344-invisible-woman.jpg",
                "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/sm/344-invisible-woman.jpg",
                "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/md/344-invisible-woman.jpg",
                "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/lg/344-invisible-woman.jpg"
        )
        val s2 = Superhero("2", "Invisible Woman", "344-invisible-woman", p2, a2, b2, w2, c2, i2)

        fun getHeroes(): List<Superhero> = listOf(s1,s2)

        fun getSingleHero(heroId : String): Superhero?{
                return getHeroes().firstOrNull{
                        it.id == heroId
                }
        }
}

