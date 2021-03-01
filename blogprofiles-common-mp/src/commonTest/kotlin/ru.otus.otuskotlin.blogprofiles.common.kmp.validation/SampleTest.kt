package ru.otus.otuskotlin.blogprofiles.common.kmp.validation

import kotlin.test.Test
import kotlin.test.assertEquals

internal class SampleTest {
    @Test
    fun SampleClassTest(){
        val sample = SampleClass(property1 = "test string")

        assertEquals("test string", sample.property1)
    }
}