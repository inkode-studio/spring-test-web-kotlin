package io.inkode.spring

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions

/**
 * @author Maxim Seredkin
 */
class MvcRequesterTest {
    private val mockMvc: MockMvc = mock()

    @Test
    fun testOn() {
        // Arrange
        val resultActions = mock<ResultActions>()
        whenever(mockMvc.perform(any())).thenReturn(resultActions)

        val getRequest = get("/test")

        // Act
        val result = on(mockMvc) {
            getRequest
        }

        // Assert
        Assertions.assertEquals(resultActions, result)

        verify(mockMvc).perform(getRequest)
    }
}