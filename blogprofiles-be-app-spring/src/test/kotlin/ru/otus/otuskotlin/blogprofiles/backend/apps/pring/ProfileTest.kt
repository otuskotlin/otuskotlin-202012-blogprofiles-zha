package ru.otus.otuskotlin.blogprofiles.backend.apps.pring

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.expectBody
import ru.otus.otuskotlin.blogprofiles.transport.models.users.*
import kotlin.test.assertEquals

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ProfileTest {
    private val client =WebTestClient.bindToServer().baseUrl("http://localhost:8181").build()

    private lateinit var context: ConfigurableApplicationContext

    @BeforeAll
    fun beforeAll() {
        context = app.run(profiles = "test")
    }

    @Test
    fun `Profile read`(){
        val res = client
            .post()
            .uri("/profile/read")
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .bodyValue(MpRequestUserProfileRead(
                requestId = "request-1",
                userProfileId = "profile-1"
            ))
            .exchange()
            .expectStatus().is2xxSuccessful
            .expectBody<MpResponseUserProfileRead>()
            .returnResult()
            .responseBody

        assertEquals("request-1", res?.onRequest)
        assertEquals("art@test.com", res?.data?.email)
    }

    @Test
    fun `Profile list`() {
        val res = client
            .post()
            .uri("/profile/list")
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .bodyValue(MpRequestUserProfileList(
                requestId = "request-1"
            ))
            .exchange()
            .expectStatus().is2xxSuccessful
            .expectBody<MpResponseUserProfileList>()
            .returnResult()
            .responseBody

        assertEquals("request-1", res?.onRequest)
        assertEquals(2, res?.data?.size)
    }

    @Test
    fun `Profile create`(){
        val res = client
            .post()
            .uri("/profile/create")
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .bodyValue(MpRequestUserProfileCreate(
                requestId = "request-1",
                data = MpUserProfileCreateDto(
                    email = "art@test.com"
                )
            ))
            .exchange()
            .expectStatus().is2xxSuccessful
            .expectBody<MpResponseUserProfileCreate>()
            .returnResult()
            .responseBody

        assertEquals("request-1", res?.onRequest)
        assertEquals("art@test.com", res?.data?.email)
    }

    @Test
    fun `Profile update`(){
        val res = client
            .post()
            .uri("/profile/update")
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .bodyValue(MpRequestUserProfileUpdate(
                requestId = "request-1",
                data = MpUserProfileUpdateDto(
                    id = "1",
                    email = "art@test.com"
                )
            ))
            .exchange()
            .expectStatus().is2xxSuccessful
            .expectBody<MpResponseUserProfileUpdate>()
            .returnResult()
            .responseBody

        assertEquals("request-1", res?.onRequest)
        assertEquals("art@test.com", res?.data?.email)
    }

    @Test
    fun `Profile delete`(){
        val res = client
            .post()
            .uri("/profile/delete")
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .bodyValue(MpRequestUserProfileDelete(
                requestId = "request-1",
                id = "1"
            ))
            .exchange()
            .expectStatus().is2xxSuccessful
            .expectBody<MpResponseUserProfileDelete>()
            .returnResult()
            .responseBody

        assertEquals("request-1", res?.onRequest)
        assertEquals("art@test.com", res?.data?.email)
    }
}