package ru.otus.otuskotlin.blogprofiles.transport.models.users

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.otus.otuskotlin.blogprofiles.transport.models.common.*

@Serializable
@SerialName("MpResponseUserProfileList")
data class MpResponseUserProfileList(
    override val responseId: String? = null,
    override val onRequest: String? = null,
    override val debug: IMpDebug? = null,
    override val status: MpStatusDto? = null,
    override var errors: List<MpErrorDto>? = null,
    val data: List<MpUserProfileDto>? = null,
): IMpResponse, MpMessage()