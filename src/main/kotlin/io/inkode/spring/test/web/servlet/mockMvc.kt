package io.inkode.spring.test.web.servlet

import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder

/**
 * DSL wrapper for MockMvc
 * @param mockMvc mock MVC
 * @param requestBuilder
 */
fun on(mockMvc: MockMvc, requestBuilder: () -> MockHttpServletRequestBuilder): ResultActions {
    return mockMvc.perform(requestBuilder())
}