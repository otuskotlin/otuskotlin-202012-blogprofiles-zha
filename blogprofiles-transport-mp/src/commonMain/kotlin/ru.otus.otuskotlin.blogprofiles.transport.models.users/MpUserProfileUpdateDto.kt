package ru.otus.otuskotlin.blogprofiles.transport.models.users

import kotlinx.serialization.Serializable

@Serializable
data class MpUserProfileUpdateDto (
    val id: String? = null,
    val firstName: String? = null,
    val lastName: String? = null,
    val patronymic: String? = null,
    val email: String? = null,
    val avatar: String? = null,
)