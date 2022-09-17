package com.acme.films.rest

import com.acme.films.domain.Actor
import com.acme.films.service.ActorService
import com.acme.films.util.getActorsList
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.micronaut.core.type.Argument
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.kotest.MicronautKotestExtension.getMock
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlin.time.Duration.Companion.seconds

@MicronautTest
class ActorControllerTest(
    @Client("/actor") private val httpClient: HttpClient,
    private val actorService: ActorService
): FunSpec({

    test("should be return 200 and list actor").config(timeout = 100.seconds) {
        val actorServiceMock = getMock(actorService)
        val actorList = getActorsList()

        every {
            actorServiceMock.getAll()
        } answers {
            actorList
        }

        val result = httpClient.toBlocking().exchange(
            HttpRequest.GET<String>("/"),
            Argument.listOf(Actor::class.java)
        )

        verify(exactly = 1) {
            actorServiceMock.getAll()
        }

        result.status shouldBe HttpStatus.OK
        result.body() shouldBe actorList
    }

}) {
    @MockBean(ActorService::class)
    fun actorService(): ActorService = mockk()
}