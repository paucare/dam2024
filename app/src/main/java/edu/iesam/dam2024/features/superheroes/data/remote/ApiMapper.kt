package edu.iesam.dam2024.features.superheroes.data.remote;

import edu.iesam.dam2024.features.superheroes.domain.Superhero;

fun SuperheroApiModel.toModel(): Superhero {
    return Superhero(this.id,this.name,this.slug,this.powerstas,this.appearance,this.biography,this.work,this.connections,this.images.md)
}