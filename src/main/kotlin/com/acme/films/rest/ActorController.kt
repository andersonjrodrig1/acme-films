package com.acme.films.rest

import com.acme.films.domain.Actor
import com.acme.films.service.ActorService
import io.micronaut.http.annotation.*
import java.util.Optional

@Controller("/")
class ActorController(
    private val actorService: ActorService
) {
    @Get("actor/{id}")
    fun getActorById(id: Int): Optional<Actor> = actorService.getById(id)

    @Post("actor")
    fun saveActor(actor: Actor): Actor = actorService.save(actor)

    @Put("actor")
    fun editActor(actor: Actor): Actor = actorService.edit(actor)

    @Delete("actor/{id}")
    fun deleteActor(id: Int) = actorService.delete(id)

    @Get("actor")
    fun getActors(): MutableIterable<Actor> = actorService.getAll()
}