package ru.otus.otuskotlin.blogprofiles.transport.models.common

interface IMpRequest {
    val requestId: String?
    var debug: IMpDebug?
}