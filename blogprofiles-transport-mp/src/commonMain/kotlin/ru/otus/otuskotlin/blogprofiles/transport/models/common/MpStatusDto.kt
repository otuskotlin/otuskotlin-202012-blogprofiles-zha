package ru.otus.otuskotlin.blogprofiles.transport.models.common

import kotlinx.serialization.Serializable

@Serializable
enum class MpStatusDto {
    SUCCESS,
    BAD_REQUEST,
    NOT_FOUND
}
