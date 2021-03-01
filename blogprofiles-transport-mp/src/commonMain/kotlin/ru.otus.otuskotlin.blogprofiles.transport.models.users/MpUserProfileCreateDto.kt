package ru.otus.otuskotlin.blogprofiles.transport.models.users

import kotlinx.serialization.Serializable

@Serializable
data class MpUserProfileCreateDto (
    val firstName: String? = null,
    val lastName: String? = null,
    val patronymic: String? = null,
    val email: String? = null,
    val avatar: String? = null,
)