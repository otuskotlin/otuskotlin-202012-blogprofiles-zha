package ru.otus.otuskotlin.blogprofiles.common.be

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SampleBEClassTest {

    @Test
    fun sampleTest(){
        val sc = SampleBEClass("str1", 1)
        assertTrue("str1" == sc.p1)
        assertFalse(1 == sc.p2)
    }
}