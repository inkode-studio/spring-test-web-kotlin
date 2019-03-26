package io.inkode.spring.test.web.servlet

import io.inkode.spring.test.web.servlet.request.get
import org.junit.Assert.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.http.MediaType.*
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author Maxim Seredkin
 */
@ExtendWith(SpringExtension::class)
@SpringBootTest
@AutoConfigureMockMvc
class MockMvcIT {
    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var testController: TestConfig.TestController

    @Test
    fun context() {
        assertNotNull(mockMvc)
        assertNotNull(testController)
    }

    @Test
    fun on() {
        // Act
        val result = on(mockMvc) {
            get("/test") {
                contentType(APPLICATION_JSON)
            }
        }

        // Assert
        result.andExpect(status().isOk)
    }

    @Test
    fun onWhenUnsupportedMediaType() {
        // Act
        val result = on(mockMvc) {
            get("/test") {
                contentType(APPLICATION_XML)
            }
        }

        // Assert
        result.andExpect(status().isUnsupportedMediaType)
    }

    @Test
    fun onWhenNotFound() {
        // Act
        val result = on(mockMvc) {
            get("/test/not-found") {
                contentType(APPLICATION_JSON)
            }
        }

        // Assert
        result.andExpect(status().isNotFound)
    }

    @TestConfiguration
    class TestConfig {
        @RestController
        @RequestMapping("test", consumes = [APPLICATION_JSON_VALUE])
        class TestController {
            @GetMapping
            fun index() = { }
        }
    }
}