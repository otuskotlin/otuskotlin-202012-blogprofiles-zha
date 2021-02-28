package ru.otus.otuskotlin.blogprofiles.transport.models.common

import kotlinx.serialization.Serializable

@Serializable
data class MpErrorDto (
    val code: String? = null,
    val message: String? = null,
    val field: String? = null,
    val level: ErrorLevelDto? = null
)
