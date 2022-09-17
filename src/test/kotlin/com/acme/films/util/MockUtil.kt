package com.acme.films.util

import com.acme.films.domain.Actor
import java.time.LocalDateTime

fun getEmptyList() = emptyList<Actor>()

fun getActorsList() = mutableListOf(
    Actor(
        actor_id = 1,
        first_name = "test 1",
        last_name = "last name",
        age = 18,
        last_update = LocalDateTime.parse("2022-01-01T23:59:59.997")
    ),
    Actor(
        actor_id = 2,
        first_name = "test 2",
        last_name = "last name",
        age = 19,
        last_update = LocalDateTime.parse("2022-01-01T23:59:59.997")
    ),
    Actor(
        actor_id = 3,
        first_name = "test 3",
        last_name = "last name",
        age = 20,
        last_update = LocalDateTime.parse("2022-01-01T23:59:59.997")
    )
)