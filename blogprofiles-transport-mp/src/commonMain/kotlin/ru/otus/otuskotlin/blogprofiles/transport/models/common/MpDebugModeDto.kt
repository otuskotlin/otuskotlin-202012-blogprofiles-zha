package ru.otus.otuskotlin.blogprofiles.transport.models.common

import kotlinx.serialization.Serializable

@Serializable
enum class MpDebugModeDto {
    PROD,
    STUB
}
