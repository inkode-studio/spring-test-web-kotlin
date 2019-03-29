package com.underkode.spring.test.web.servlet

import com.nhaarman.mockitokotlin2.*
import com.underkode.spring.test.web.servlet.request.get
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions

/**
 * @author Maxim Seredkin
 */
class MockMvcKtTest {
    private val mockMvc: MockMvc = mock()

    @Test
    fun on() {
        // Arrange
        val resultActions = mock<ResultActions>()
        whenever(mockMvc.perform(any())).thenReturn(resultActions)

        val requestBuilder = get("/test") {
            contentType(APPLICATION_JSON)
        }

        // Act
        val result = on(mockMvc) {
            requestBuilder
        }

        // Assert
        assertEquals(resultActions, result)

        verify(mockMvc).perform(requestBuilder)

        verifyNoMoreInteractions(
            mockMvc,
            resultActions
        )
    }
}