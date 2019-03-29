package com.underkode.spring.test.web.servlet.request

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.skyscreamer.jsonassert.JSONAssert
import org.skyscreamer.jsonassert.JSONCompareMode
import org.springframework.mock.web.MockServletContext
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import java.io.FileNotFoundException

/**
 * @author Maxim Seredkin
 */
internal class MockHttpServletRequestBuilderKtTest {
    @Test
    fun contentFromResource() {
        // Act
        val result = MockMvcRequestBuilders.get("/").contentFromResource("/content.json")

        // Assert
        JSONAssert.assertEquals(
            "Content not set or not equal to expected",
            "{\"field\": \"value\"}",
            String(result.buildRequest(MockServletContext()).contentAsByteArray!!),
            JSONCompareMode.STRICT
        )
    }

    @Test
    fun contentFromResourceWhenFileNotExists() {
        // Act && Assert
        assertThrows<FileNotFoundException>("Classpath file is exists") {
            MockMvcRequestBuilders.get("/").contentFromResource("/not_exists.json")
        }
    }
}