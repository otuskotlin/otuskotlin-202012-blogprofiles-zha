package ru.otus.otuskotlin.blogprofiles.transport.models.users

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.otus.otuskotlin.blogprofiles.transport.models.common.IMpDebug
import ru.otus.otuskotlin.blogprofiles.transport.models.common.IMpRequest
import ru.otus.otuskotlin.blogprofiles.transport.models.common.MpMessage

@Serializable
@SerialName("MpRequestUserProfileUpdate")
data class MpRequestUserProfileUpdate(
    override val requestId: String? = null,
    override var debug: IMpDebug? = null,
    val data: MpUserProfileUpdateDto? = null,
) : IMpRequest, MpMessage()