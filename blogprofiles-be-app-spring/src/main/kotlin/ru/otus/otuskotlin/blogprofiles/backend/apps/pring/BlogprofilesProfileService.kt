package ru.otus.otuskotlin.blogprofiles.backend.apps.pring

import org.springframework.web.servlet.function.ServerRequest
import org.springframework.web.servlet.function.ServerResponse
import org.springframework.web.servlet.function.ServerResponse.ok
import ru.otus.otuskotlin.blogprofiles.transport.models.common.MpStatusDto
import ru.otus.otuskotlin.blogprofiles.transport.models.users.*

class BlogprofilesProfileService {
    fun read(request: ServerRequest): ServerResponse {
        val id = request.body(MpRequestUserProfileRead::class.java)?.userProfileId;
        return ok().body(
            MpResponseUserProfileRead(
                responseId = "response-1",
                onRequest = "request-1",
                status = MpStatusDto.SUCCESS,
                data = MpUserProfileDto(
                    firstName = "art",
                    email = "art@test.com"
                )
            )
        )
    }

    fun list(request: ServerRequest): ServerResponse {
        val requestId = request.body(MpRequestUserProfileList::class.java)?.requestId;
        return ok().body(
            MpResponseUserProfileList(
                responseId = "response-1",
                onRequest = requestId,
                status = MpStatusDto.SUCCESS,
                data = listOf(
                    MpUserProfileDto(email = "art@test.com"),
                    MpUserProfileDto(email = "t@test.com")
                )
            )
        )
    }

    fun create(request: ServerRequest): ServerResponse {
        val request = request.body(MpRequestUserProfileCreate::class.java)
        return ok().body(
            MpResponseUserProfileCreate(
                responseId = "response-1",
                onRequest = request.requestId,
                status = MpStatusDto.SUCCESS,
                data = MpUserProfileDto(email = request.data?.email)
            )
        )
    }

    fun update(request: ServerRequest): ServerResponse {
        val request = request.body(MpRequestUserProfileUpdate::class.java)
        return ok().body(
            MpResponseUserProfileUpdate(
                responseId = "response-1",
                onRequest = request.requestId,
                status = MpStatusDto.SUCCESS,
                data = MpUserProfileDto(email = request.data?.email)
            )
        )
    }

    fun delete(request: ServerRequest): ServerResponse {
        val request = request.body(MpRequestUserProfileUpdate::class.java)
        return ok().body(
            MpResponseUserProfileDelete(
                responseId = "response-1",
                onRequest = request.requestId,
                status = MpStatusDto.SUCCESS,
                data = MpUserProfileDto(email = "art@test.com")
            )
        )
    }
}