package com.acme.films.domain

import io.micronaut.core.annotation.Introspected
import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import io.micronaut.data.annotation.MappedProperty
import java.time.LocalDateTime

@Introspected
@MappedEntity(value = "actor")
data class Actor(
    @field:Id
    @field:GeneratedValue(GeneratedValue.Type.AUTO)
    @MappedProperty(value = "actor_id")
    val actor_id: Int? = null,

    @MappedProperty(value = "first_name")
    var first_name: String,

    @MappedProperty(value = "last_name")
    var last_name: String,

    @MappedProperty(value = "age")
    var age: Int,

    @MappedProperty(value = "last_update")
    val last_update: LocalDateTime? = null
)
