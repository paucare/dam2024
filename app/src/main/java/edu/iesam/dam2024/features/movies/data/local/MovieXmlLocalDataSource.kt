package edu.iesam.dam2024.features.movies.data.local

import android.content.Context
import com.google.gson.Gson
import edu.iesam.dam2024.R
import edu.iesam.dam2024.features.movies.domain.Movie

class MovieXmlLocalDataSource(private val context: Context) {
    private val gson = Gson()

    private val sharedPreferences = context.getSharedPreferences(
        context.getString(R.string.name_file_xml),Context.MODE_PRIVATE
    )

    fun save(movie: Movie) {
       /* sharedPreferences.edit().apply(){
            putString("id",movie.id)
            putString("title",movie.title)
            putString("poster",movie.poster)
            apply()
            }
        */
    }

    fun saveAll(movies: List<Movie>) {
        val editor = sharedPreferences.edit()
        movies.forEach{ movie ->
            editor.putString(movie.id,gson.toJson(movie))
        }
        editor.apply()
    }

    fun findAll() : List<Movie> {
        val movies = mutableListOf<Movie>()
        val mapMovies = sharedPreferences.all // as Map<String, String>
        mapMovies.values.forEach { jsonMovie ->
            val movie = gson.fromJson(jsonMovie as String, Movie::class.java)
            movies.add(movie)
        }
        return movies
    }

    fun findById(movieId : String) : Movie? {
        return sharedPreferences.getString(movieId,null)?.let{ movie ->
            gson.fromJson(movie,Movie::class.java)
        }
    }

    fun delete(){
        sharedPreferences.edit().clear().apply()// elimina el fichero xml
    }
    fun deleteById(){
        sharedPreferences.edit().remove("id").apply()
    }
}