
import ru.otus.otuskotlin.blogprofiles.common.be.context.MpBeContext
import ru.otus.otuskotlin.blogprofiles.common.be.models.MpUserProfileIdModel
import ru.otus.otuskotlin.blogprofiles.common.be.models.MpUserProfileModel
import ru.otus.otuskotlin.blogprofiles.transport.models.common.IMpRequest
import ru.otus.otuskotlin.blogprofiles.transport.models.users.*
import kotlin.test.Test
import kotlin.test.assertEquals

class MappersTest {

    @Test
    fun requestCreateMapperTest(){
        val request: IMpRequest = MpRequestUserProfileCreate(
            data = MpUserProfileCreateDto(
                firstName = "Art",
                lastName = "Z",
                email = "test@mail.com",
            )
        )
        val context = MpBeContext()
        context.setQuery(request)
        assertEquals("test@mail.com", context.requestUserProfile.email)
    }

    @Test
    fun requestReadMapperTest(){
        val request: IMpRequest = MpRequestUserProfileRead(
            userProfileId = "user-profile-1"
        )
        val context = MpBeContext()
        context.setQuery(request)
        assertEquals("user-profile-1", context.requestUserProfileId.id)
    }

    @Test
    fun createDtoToModelTest() {
        val dto = MpUserProfileCreateDto(
            email = "test@mail.com"
        )
        val model = dto.toModel()
        assertEquals("test@mail.com", model.email)
    }

    @Test
    fun updateDtoToModelTest() {
        val dto = MpUserProfileUpdateDto(
            id = "user-profile-1",
            email = "test@mail.com"
        )
        val model = dto.toModel()
        assertEquals(MpUserProfileIdModel("user-profile-1"), model.id)
        assertEquals("test@mail.com", model.email)
    }
}

private fun MpBeContext.setQuery(request: IMpRequest) =
    when (request) {
        is MpRequestUserProfileRead -> setQuery(request)
        is MpRequestUserProfileCreate -> setQuery(request)
        is MpRequestUserProfileUpdate -> setQuery(request)
        is MpRequestUserProfileDelete -> setQuery(request)

        else -> null
    }

private fun MpBeContext.setQuery(request: MpRequestUserProfileRead) {
    this.requestUserProfileId = request.userProfileId?.let { MpUserProfileIdModel(it) }?: MpUserProfileIdModel.NONE
}

private fun MpBeContext.setQuery(request: MpRequestUserProfileCreate) {
    request.data?.let { data ->
        this.requestUserProfile = MpUserProfileModel(
            firstName = data.firstName?: "",
            lastName = data.lastName?: "",
            patronymic = data.patronymic?: "",
            email = data.email?: "",
            avatar = data.avatar?: "",
        )
    }
}

private fun MpBeContext.setQuery(request: MpRequestUserProfileUpdate) {
    request.data?.let { data ->
        this.requestUserProfile = MpUserProfileModel(
            id = data.id?.let{ MpUserProfileIdModel(it)}?: MpUserProfileIdModel.NONE,
            firstName = data.firstName?: "",
            lastName = data.lastName?: "",
            patronymic = data.patronymic?: "",
            email = data.email?: "",
            avatar = data.avatar?: "",
        )
    }
}

private fun MpBeContext.setQuery(request: MpRequestUserProfileDelete) {
    this.requestUserProfileId = request.id?.let { MpUserProfileIdModel(it) }?: MpUserProfileIdModel.NONE
}

private fun MpUserProfileCreateDto.toModel() =
    MpUserProfileModel(
        firstName = this.firstName?: "",
        lastName = this.lastName?: "",
        patronymic = this.patronymic?: "",
        email = this.email?: "",
        avatar = this.avatar?: "",
    )

private fun MpUserProfileUpdateDto.toModel() =
    MpUserProfileModel(
        id = this.id?.let { MpUserProfileIdModel(it)}?: MpUserProfileIdModel.NONE,
        firstName = this.firstName?: "",
        lastName = this.lastName?: "",
        patronymic = this.patronymic?: "",
        email = this.email?: "",
        avatar = this.avatar?: "",
    )