package ru.otus.otuskotlin.blogprofiles.common.be.models

inline class MpUserProfileIdModel (
    val id: String,
) {
    companion object {
        val NONE = MpUserProfileIdModel("")
    }
}
