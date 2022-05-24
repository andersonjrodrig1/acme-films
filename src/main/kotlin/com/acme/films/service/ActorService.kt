package com.acme.films.service

import com.acme.films.domain.Actor
import com.acme.films.repository.ActorRepository
import jakarta.inject.Singleton
import org.slf4j.LoggerFactory
import java.util.*

@Singleton
class ActorService(
    private val actorRepository: ActorRepository
) {
    private val logger = LoggerFactory.getLogger(ActorService::class.java)

    fun getById(id: Int): Optional<Actor> {
        logger.info("Get actor by id: $id")
        return actorRepository.findById(id)
    }

    fun save(actor: Actor): Actor {
        logger.info("Save actor: $actor")
        return actorRepository.save(actor)
    }

    fun edit(actor: Actor): Actor {
        logger.info("Update actor: $actor")
        return actorRepository.update(actor)
    }

    fun delete(id: Int) {
        logger.info("Delete actor by id: $id")
        return actorRepository.deleteById(id)
    }

    fun getAll(): MutableIterable<Actor> {
        logger.info("Get all actors")
        return actorRepository.findAll()
    }
}