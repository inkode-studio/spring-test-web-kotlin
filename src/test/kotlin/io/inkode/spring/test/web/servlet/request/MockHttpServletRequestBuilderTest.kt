package io.inkode.spring.test.web.servlet.request

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.skyscreamer.jsonassert.JSONAssert.assertEquals
import org.skyscreamer.jsonassert.JSONCompareMode.STRICT
import org.springframework.mock.web.MockServletContext
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import java.io.FileNotFoundException

/**
 * @author Maxim Seredkin
 */
class MockHttpServletRequestBuilderTest {
    @Test
    fun bodyFromResource() {
        // Act
        val result = MockMvcRequestBuilders.get("/").contentFromResource("/content.json")

        // Assert
        assertEquals(
            "Content not set or not equal to expected",
            "{\"field\": \"value\"}",
            String(result.buildRequest(MockServletContext()).contentAsByteArray!!),
            STRICT
        )
    }

    @Test
    fun bodyFromResourceWhenFileNotExists() {
        // Act && Assert
        assertThrows<FileNotFoundException>("Classpath file is exists") {
            MockMvcRequestBuilders.get("/").contentFromResource("/not_exists.json")
        }
    }
}