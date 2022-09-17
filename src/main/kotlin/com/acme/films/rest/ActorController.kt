package com.acme.films.rest

import com.acme.films.domain.Actor
import com.acme.films.service.ActorService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Put
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.Controller
import java.util.Optional

@Controller("/actor")
open class ActorController(
    private val actorService: ActorService
) {
    @Get("/{id}")
    open fun getActorById(id: Int): HttpResponse<Optional<Actor>> = HttpResponse.ok(actorService.getById(id))

    @Post
    open fun saveActor(actor: Actor): HttpResponse<Actor> = HttpResponse.created(actorService.save(actor))

    @Put
    open fun editActor(actor: Actor): HttpResponse<Actor> = HttpResponse.ok(actorService.edit(actor))

    @Delete("/{id}")
    open fun deleteActor(id: Int): HttpResponse<Unit> = HttpResponse.ok(actorService.delete(id))

    @Get
    open fun getActors(): HttpResponse<MutableList<Actor>> = HttpResponse.ok(actorService.getAll())
}