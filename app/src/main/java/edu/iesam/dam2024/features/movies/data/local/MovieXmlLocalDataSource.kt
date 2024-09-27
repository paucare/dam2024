package edu.iesam.dam2024.features.movies.data.local

import android.content.Context
import edu.iesam.dam2024.R
import edu.iesam.dam2024.features.movies.domain.Movie

class MovieXmlLocalDataSource(private val context: Context) {
    private val sharedPreferences = context.getSharedPreferences(
        context.getString(R.string.name_file_xml),Context.MODE_PRIVATE
    )

    fun save(movie: Movie) {
        sharedPreferences.edit().apply(){
            putString("id",movie.id)
            putString("title",movie.title)
            putString("poster",movie.poster)
            apply()
        }
    }
    fun find() : Movie{
        return Movie(
            sharedPreferences.getString("id","")!!,
            sharedPreferences.getString("title","")!!,
            sharedPreferences.getString("poster","")!!
        )
    }

    fun  delete(){
        sharedPreferences.edit().clear().apply() // elimina el fichero xml
    }
}