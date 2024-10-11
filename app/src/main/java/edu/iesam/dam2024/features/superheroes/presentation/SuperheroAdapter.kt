package edu.iesam.dam2024.features.superheroes.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.iesam.dam2024.R
import edu.iesam.dam2024.app.extensions.loadUrl
import edu.iesam.dam2024.features.superheroes.domain.Superhero


class SuperheroAdapter(
    private val superheroes: List<Superhero>,
    private val onItemClick: (String) -> Unit

) : RecyclerView.Adapter<SuperheroAdapter.SuperheroViewHolder>() {

    class SuperheroViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.superheroImage)
        val nameView: TextView = view.findViewById(R.id.superheroName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_superhero_item, parent, false)
        return SuperheroViewHolder(view)
    }

    override fun onBindViewHolder(holder: SuperheroViewHolder, position: Int) {
        val superhero = superheroes[position]
        holder.imageView.loadUrl(superhero.images.sm)
        holder.nameView.text = superhero.name

        holder.itemView.setOnClickListener {
            onItemClick(superhero.id) // Call the click handler with the superhero's ID
        }
    }


    override fun getItemCount(): Int {
        return superheroes.size
    }
}

