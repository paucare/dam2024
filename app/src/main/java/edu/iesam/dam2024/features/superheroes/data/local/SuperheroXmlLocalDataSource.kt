package edu.iesam.dam2024.features.superheroes.data.local

import android.content.Context
import com.google.gson.Gson
import com.google.gson.JsonDeserializationContext
import edu.iesam.dam2024.R
import edu.iesam.dam2024.features.movies.domain.Movie
import edu.iesam.dam2024.features.superheroes.domain.Superhero

class SuperheroXmlLocalDataSource(
    private val context: Context
) {
    private val gson = Gson()

    private val sharedPref = context.getSharedPreferences(
        context.getString(R.string.name_file_xml2),Context.MODE_PRIVATE
    )
    fun save(item : Superhero){
        val editor = sharedPref.edit()
        editor.putString(item.id,gson.toJson(item))
        editor.apply()
    }
    fun saveAll(heroes : List<Superhero>?){
        val editor = sharedPref.edit()
        heroes?.forEach { hero ->
            editor.putString(hero.id,gson.toJson(hero))
        }
        editor.apply()
    }
    fun findById(heroId : String): Superhero? {
        return sharedPref.getString(heroId,null)?.let { hero ->
            gson.fromJson(hero,Superhero::class.java)
        }
    }
    fun findAll(): List<Superhero>?{
        val heroes = ArrayList<Superhero>()
        val mapHeroes = sharedPref.all // as MapString<String>
        mapHeroes.values.forEach{ jsonHero ->
            val hero= gson.fromJson(jsonHero as String, Superhero::class.java)
            heroes.add(hero)
        }
        return heroes
    }
    fun delete(){
        sharedPref.edit().clear().apply()
    }
    fun deleteById(heroId: String){
        sharedPref.edit().remove(heroId).commit()
    }


}