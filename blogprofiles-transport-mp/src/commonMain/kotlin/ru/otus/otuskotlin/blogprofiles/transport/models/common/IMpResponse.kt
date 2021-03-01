package ru.otus.otuskotlin.blogprofiles.transport.models.common

interface IMpResponse {
    val responseId: String?
    val onRequest: String?
    val debug: IMpDebug?
    val status: MpStatusDto?
    var errors: List<MpErrorDto>?
}