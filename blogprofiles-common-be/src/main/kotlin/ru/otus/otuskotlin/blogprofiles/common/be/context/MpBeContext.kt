package ru.otus.otuskotlin.blogprofiles.common.be.context

import ru.otus.otuskotlin.blogprofiles.common.be.models.MpUserProfileIdModel
import ru.otus.otuskotlin.blogprofiles.common.be.models.MpUserProfileModel

data class MpBeContext (
    var requestUserProfileId: MpUserProfileIdModel = MpUserProfileIdModel.NONE,
    var requestUserProfile: MpUserProfileModel = MpUserProfileModel.NONE,
    var responseUserProfile: MpUserProfileModel = MpUserProfileModel.NONE,
)