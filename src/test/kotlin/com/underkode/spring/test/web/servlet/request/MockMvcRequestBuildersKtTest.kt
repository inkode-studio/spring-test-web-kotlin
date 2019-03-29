package com.underkode.spring.test.web.servlet.request

import org.junit.Assert.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.springframework.http.HttpMethod.GET
import org.springframework.http.MediaType.*
import org.springframework.mock.web.MockServletContext
import java.net.URI

/**
 * @author Maxim Seredkin
 */
internal class MockMvcRequestBuildersKtTest {
    @Test
    fun getByUrlTemplateAndUriVars() {
        // Act
        val result = get("/test/{id}", "1") {
            contentType(APPLICATION_JSON)
        }

        // Assert
        result.buildRequest(MockServletContext())
            .let { buildRequest ->
                assertAll(
                    { assertEquals("GET", buildRequest.method) },
                    { assertEquals("/test/1", buildRequest.requestURI) },
                    { assertEquals(APPLICATION_JSON_VALUE, buildRequest.contentType) }
                )
            }
    }

    @Test
    fun getByUri() {
        // Act
        val result = get(URI("/test/1")) {
            contentType(APPLICATION_JSON)
        }

        // Assert
        result.buildRequest(MockServletContext())
            .let { buildRequest ->
                assertAll(
                    { assertEquals("GET", buildRequest.method) },
                    { assertEquals("/test/1", buildRequest.requestURI) },
                    { assertEquals(APPLICATION_JSON_VALUE, buildRequest.contentType) }
                )
            }
    }

    @Test
    fun postByUrlTemplateAndUriVars() {
        // Act
        val result = post("/test/{id}", "1") {
            contentType(APPLICATION_JSON)
        }

        // Assert
        result.buildRequest(MockServletContext())
            .let { buildRequest ->
                assertAll(
                    { assertEquals("POST", buildRequest.method) },
                    { assertEquals("/test/1", buildRequest.requestURI) },
                    { assertEquals(APPLICATION_JSON_VALUE, buildRequest.contentType) }
                )
            }
    }

    @Test
    fun postByUri() {
        // Act
        val result = post(URI("/test/1")) {
            contentType(APPLICATION_JSON)
        }

        // Assert
        result.buildRequest(MockServletContext())
            .let { buildRequest ->
                assertAll(
                    { assertEquals("POST", buildRequest.method) },
                    { assertEquals("/test/1", buildRequest.requestURI) },
                    { assertEquals(APPLICATION_JSON_VALUE, buildRequest.contentType) }
                )
            }
    }

    @Test
    fun putByUrlTemplateAndUriVars() {
        // Act
        val result = put("/test/{id}", "1") {
            contentType(APPLICATION_JSON)
        }

        // Assert
        result.buildRequest(MockServletContext())
            .let { buildRequest ->
                assertAll(
                    { assertEquals("PUT", buildRequest.method) },
                    { assertEquals("/test/1", buildRequest.requestURI) },
                    { assertEquals(APPLICATION_JSON_VALUE, buildRequest.contentType) }
                )
            }
    }

    @Test
    fun putByUri() {
        // Act
        val result = put(URI("/test/1")) {
            contentType(APPLICATION_JSON)
        }

        // Assert
        result.buildRequest(MockServletContext())
            .let { buildRequest ->
                assertAll(
                    { assertEquals("PUT", buildRequest.method) },
                    { assertEquals("/test/1", buildRequest.requestURI) },
                    { assertEquals(APPLICATION_JSON_VALUE, buildRequest.contentType) }
                )
            }
    }

    @Test
    fun patchByUrlTemplateAndUriVars() {
        // Act
        val result = patch("/test/{id}", "1") {
            contentType(APPLICATION_JSON)
        }

        // Assert
        result.buildRequest(MockServletContext())
            .let { buildRequest ->
                assertAll(
                    { assertEquals("PATCH", buildRequest.method) },
                    { assertEquals("/test/1", buildRequest.requestURI) },
                    { assertEquals(APPLICATION_JSON_VALUE, buildRequest.contentType) }
                )
            }
    }

    @Test
    fun patchByUri() {
        // Act
        val result = patch(URI("/test/1")) {
            contentType(APPLICATION_JSON)
        }

        // Assert
        result.buildRequest(MockServletContext())
            .let { buildRequest ->
                assertAll(
                    { assertEquals("PATCH", buildRequest.method) },
                    { assertEquals("/test/1", buildRequest.requestURI) },
                    { assertEquals(APPLICATION_JSON_VALUE, buildRequest.contentType) }
                )
            }
    }

    @Test
    fun deleteByUrlTemplateAndUriVars() {
        // Act
        val result = delete("/test/{id}", "1") {
            contentType(APPLICATION_JSON)
        }

        // Assert
        result.buildRequest(MockServletContext())
            .let { buildRequest ->
                assertAll(
                    { assertEquals("DELETE", buildRequest.method) },
                    { assertEquals("/test/1", buildRequest.requestURI) },
                    { assertEquals(APPLICATION_JSON_VALUE, buildRequest.contentType) }
                )
            }
    }

    @Test
    fun deleteByUri() {
        // Act
        val result = delete(URI("/test/1")) {
            contentType(APPLICATION_JSON)
        }

        // Assert
        result.buildRequest(MockServletContext())
            .let { buildRequest ->
                assertAll(
                    { assertEquals("DELETE", buildRequest.method) },
                    { assertEquals("/test/1", buildRequest.requestURI) },
                    { assertEquals(APPLICATION_JSON_VALUE, buildRequest.contentType) }
                )
            }
    }

    @Test
    fun optionsByUrlTemplateAndUriVars() {
        // Act
        val result = options("/test/{id}", "1") {
            contentType(APPLICATION_JSON)
        }

        // Assert
        result.buildRequest(MockServletContext())
            .let { buildRequest ->
                assertAll(
                    { assertEquals("OPTIONS", buildRequest.method) },
                    { assertEquals("/test/1", buildRequest.requestURI) },
                    { assertEquals(APPLICATION_JSON_VALUE, buildRequest.contentType) }
                )
            }
    }

    @Test
    fun optionsByUri() {
        // Act
        val result = options(URI("/test/1")) {
            contentType(APPLICATION_JSON)
        }

        // Assert
        result.buildRequest(MockServletContext())
            .let { buildRequest ->
                assertAll(
                    { assertEquals("OPTIONS", buildRequest.method) },
                    { assertEquals("/test/1", buildRequest.requestURI) },
                    { assertEquals(APPLICATION_JSON_VALUE, buildRequest.contentType) }
                )
            }
    }

    @Test
    fun headByUrlTemplateAndUriVars() {
        // Act
        val result = head("/test/{id}", "1") {
            contentType(APPLICATION_JSON)
        }

        // Assert
        result.buildRequest(MockServletContext())
            .let { buildRequest ->
                assertAll(
                    { assertEquals("HEAD", buildRequest.method) },
                    { assertEquals("/test/1", buildRequest.requestURI) },
                    { assertEquals(APPLICATION_JSON_VALUE, buildRequest.contentType) }
                )
            }
    }

    @Test
    fun headByUri() {
        // Act
        val result = head(URI("/test/1")) {
            contentType(APPLICATION_JSON)
        }

        // Assert
        result.buildRequest(MockServletContext())
            .let { buildRequest ->
                assertAll(
                    { assertEquals("HEAD", buildRequest.method) },
                    { assertEquals("/test/1", buildRequest.requestURI) },
                    { assertEquals(APPLICATION_JSON_VALUE, buildRequest.contentType) }
                )
            }
    }

    @Test
    fun requestByHttpMethodAndUrlTemplateWithUriVars() {
        // Act
        val result = request(GET, "/test/{id}", "1") {
            contentType(APPLICATION_JSON)
        }

        // Assert
        result.buildRequest(MockServletContext())
            .let { buildRequest ->
                assertAll(
                    { assertEquals("GET", buildRequest.method) },
                    { assertEquals("/test/1", buildRequest.requestURI) },
                    { assertEquals(APPLICATION_JSON_VALUE, buildRequest.contentType) }
                )
            }
    }

    @Test
    fun requestByHttpMethodAndUri() {
        // Act
        val result = request(GET, URI("/test/1")) {
            contentType(APPLICATION_JSON)
        }

        // Assert
        result.buildRequest(MockServletContext())
            .let { buildRequest ->
                assertAll(
                    { assertEquals("GET", buildRequest.method) },
                    { assertEquals("/test/1", buildRequest.requestURI) },
                    { assertEquals(APPLICATION_JSON_VALUE, buildRequest.contentType) }
                )
            }
    }

    @Test
    fun requestByHttpMethodStringAndUri() {
        // Act
        val result = request("GET", URI("/test/1")) {
            contentType(APPLICATION_JSON)
        }

        // Assert
        result.buildRequest(MockServletContext())
            .let { buildRequest ->
                assertAll(
                    { assertEquals("GET", buildRequest.method) },
                    { assertEquals("/test/1", buildRequest.requestURI) },
                    { assertEquals(APPLICATION_JSON_VALUE, buildRequest.contentType) }
                )
            }
    }

    @Test
    fun multipartByUrlTemplateAndUriVars() {
        // Act
        val result = multipart("/test/{id}", "1")

        // Assert
        result.buildRequest(MockServletContext())
            .let { buildRequest ->
                assertAll(
                    { assertEquals("POST", buildRequest.method) },
                    { assertEquals("/test/1", buildRequest.requestURI) },
                    { assertEquals(MULTIPART_FORM_DATA_VALUE, buildRequest.contentType) }
                )
            }
    }

    @Test
    fun multipartByUri() {
        // Act
        val result = multipart(URI("/test/1"))

        // Assert
        result.buildRequest(MockServletContext())
            .let { buildRequest ->
                assertAll(
                    { assertEquals("POST", buildRequest.method) },
                    { assertEquals("/test/1", buildRequest.requestURI) },
                    { assertEquals(MULTIPART_FORM_DATA_VALUE, buildRequest.contentType) }
                )
            }
    }
}