import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass
import ru.otus.otuskotlin.blogprofiles.transport.models.common.MpMessage
import ru.otus.otuskotlin.blogprofiles.transport.models.users.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

internal class SerializationTest {

    @Test
    fun serializeMpRequestUserProfileReadTest(){
        val request: MpMessage = MpRequestUserProfileRead(
            userProfileId = "1",
        )
        val json = Json {
            prettyPrint = true
            serializersModule = SerializersModule {
                polymorphic(MpMessage::class) {
                    subclass(MpRequestUserProfileRead::class)
                }
            }
            classDiscriminator = "type"
        }
        val reqStr = json.encodeToString(MpMessage.serializer(), request)
        println(reqStr)
        assertTrue { reqStr.contains("1") }

        val dto = json.decodeFromString(MpMessage.serializer(), reqStr)
        assertEquals("1", (dto as? MpRequestUserProfileRead)?.userProfileId)
    }
    @Test
    fun serializeMpResponseUserProfileRead(){
        val response = MpResponseUserProfileRead(
            data = MpUserProfileDto(
                email = "test@mail.com"
            )
        )
        val json = Json { prettyPrint = true }
        val respStr = json.encodeToString(MpResponseUserProfileRead.serializer(), response)
        println(respStr)
        assertTrue { respStr.contains("test@mail.com") }
        val dto = json.decodeFromString(MpResponseUserProfileRead.serializer(), respStr)
        assertEquals("test@mail.com", dto.data?.email)
    }


    @Test
    fun serializeMpRequestUserProfileCreateTest(){
        val request: MpMessage = MpRequestUserProfileCreate(
            data = MpUserProfileCreateDto(
                firstName = "Art",
                lastName = "Z",
                patronymic = "D",
                email = "test@mail.com",
            )
        )
        val json = Json {
            prettyPrint = true
            serializersModule = SerializersModule {
                polymorphic(MpMessage::class) {
                    subclass(MpRequestUserProfileCreate::class)
                }
            }
            classDiscriminator = "type"
        }
        val reqStr = json.encodeToString(MpMessage.serializer(), request)
        println(reqStr)
        assertTrue { reqStr.contains("test@mail.com") }
        val dto = json.decodeFromString(MpMessage.serializer(), reqStr)
        assertEquals("test@mail.com", (dto as? MpRequestUserProfileCreate)?.data?.email)
    }
    @Test
    fun serializeMpResponseUserProfileCreate(){
        val response = MpResponseUserProfileCreate(
            data = MpUserProfileDto(
                email = "test@mail.com"
            )
        )
        val json = Json { prettyPrint = true }
        val respStr = json.encodeToString(MpResponseUserProfileCreate.serializer(), response)
        println(respStr)
        assertTrue { respStr.contains("test@mail.com") }
        val dto = json.decodeFromString(MpResponseUserProfileCreate.serializer(), respStr)
        assertEquals("test@mail.com", dto.data?.email)
    }

    @Test
    fun serialiseMpRequestUserProfileUpdate(){
        val request = MpRequestUserProfileUpdate(
            data = MpUserProfileUpdateDto(
                email = "test@mail.com"
            )
        )
        val json = Json { prettyPrint = true }
        val respStr = json.encodeToString(MpRequestUserProfileUpdate.serializer(), request)
        println(respStr)
        assertTrue { respStr.contains("test@mail.com") }
        val dto = json.decodeFromString(MpRequestUserProfileUpdate.serializer(), respStr)
        assertEquals("test@mail.com", dto.data?.email)
    }

    @Test
    fun serialiseMpResponseUserProfileUpdate(){
        val response = MpResponseUserProfileUpdate(
            data = MpUserProfileDto(
                email = "test@mail.com"
            )
        )
        val json = Json { prettyPrint = true }
        val respStr = json.encodeToString(MpResponseUserProfileUpdate.serializer(), response)
        println(respStr)
        assertTrue { respStr.contains("test@mail.com") }
        val dto = json.decodeFromString(MpResponseUserProfileUpdate.serializer(), respStr)
        assertEquals("test@mail.com", dto.data?.email)
    }

    @Test
    fun serialiseMpRequestUserProfileDelete(){
        val request = MpRequestUserProfileDelete(
            id = "user-profile-1"
        )
        val json = Json { prettyPrint = true }
        val respStr = json.encodeToString(MpRequestUserProfileDelete.serializer(), request)
        println(respStr)
        assertTrue { respStr.contains("user-profile-1") }
        val dto = json.decodeFromString(MpRequestUserProfileDelete.serializer(), respStr)
        assertEquals("user-profile-1", dto.id)
    }

    @Test
    fun serialiseMpResponseUserProfileDelete(){
        val response = MpResponseUserProfileDelete(
            data = MpUserProfileDto(
                email = "test@mail.com"
            ),
            deleted = true
        )
        val json = Json { prettyPrint = true }
        val respStr = json.encodeToString(MpResponseUserProfileDelete.serializer(), response)
        println(respStr)
        assertTrue { respStr.contains("test@mail.com") }
        assertTrue { respStr.contains("deleted") }
        val dto = json.decodeFromString(MpResponseUserProfileDelete.serializer(), respStr)
        assertEquals("test@mail.com", dto.data?.email)
        assertTrue { dto.deleted!! }
    }

    @Test
    fun serializeMpRequestUserProfileList(){
        val request = MpRequestUserProfileList(
            filter = MpUserProfileListFilter(text = "filter")
        )
        val json = Json { prettyPrint = true }
        val respStr = json.encodeToString(MpRequestUserProfileList.serializer(), request)
        println(respStr)
        assertTrue { respStr.contains("filter") }
        val dto = json.decodeFromString(MpRequestUserProfileList.serializer(), respStr)
        assertEquals("filter", (dto as? MpRequestUserProfileList)?.filter?.text)
    }

    @Test
    fun serializeMpResponseUserProfileList() {
        val response = MpResponseUserProfileList(
            data = listOf(
                MpUserProfileDto(
                    email = "test@mail.com"
            ))
        )
        val json = Json { prettyPrint = true }
        val respStr = json.encodeToString(MpResponseUserProfileList.serializer(), response)
        println(respStr)
        assertTrue { respStr.contains("test@mail.com") }
        val dto = json.decodeFromString(MpResponseUserProfileList.serializer(), respStr)
        assertEquals("test@mail.com", dto.data?.find { it.email == "test@mail.com" }?.email)

    }
}