package io.inkode.spring.test.web.servlet

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.inkode.spring.test.web.servlet.request.get
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions

/**
 * @author Maxim Seredkin
 */
class MockMvcTest {
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
        Assertions.assertEquals(resultActions, result)

        verify(mockMvc).perform(requestBuilder)
    }
}