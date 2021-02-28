package ru.otus.otuskotlin.blogprofiles.common.be.models

data class MpUserProfileModel (
    val id: MpUserProfileIdModel = MpUserProfileIdModel.NONE,
    val firstName: String? = "",
    val lastName: String? = "",
    val patronymic: String? = "",
    val email: String? = "",
    val avatar: String? = "",
) {
    companion object {
        val NONE = MpUserProfileModel()
    }
}