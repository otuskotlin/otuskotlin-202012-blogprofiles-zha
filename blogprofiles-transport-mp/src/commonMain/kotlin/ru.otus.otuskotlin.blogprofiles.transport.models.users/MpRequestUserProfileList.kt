package ru.otus.otuskotlin.blogprofiles.transport.models.users

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.otus.otuskotlin.blogprofiles.transport.models.common.IMpDebug
import ru.otus.otuskotlin.blogprofiles.transport.models.common.IMpRequest
import ru.otus.otuskotlin.blogprofiles.transport.models.common.IMpResponse
import ru.otus.otuskotlin.blogprofiles.transport.models.common.MpMessage

@Serializable
@SerialName("MpRequestUserProfileList")
data class MpRequestUserProfileList(
    override val requestId: String? = null,
    override var debug: IMpDebug? = null,
    val filter: MpUserProfileListFilter? = null
): IMpRequest, MpMessage()