package ru.otus.otuskotlin.blogprofiles.transport.models.users

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.otus.otuskotlin.blogprofiles.transport.models.common.IMpFilter

@Serializable
@SerialName("MpUserProfileListFilter")
data class MpUserProfileListFilter (
    override val text: String? = null,
) : IMpFilter
