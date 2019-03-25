package io.inkode.spring

import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult

class MvcRequester(private val mockMvc: MockMvc) {
    fun perform(requestBuilder: MockHttpServletRequestBuilderDelegate): MvcResult {
        return mockMvc.perform(requestBuilder).andReturn()
    }

    fun perform(requestBuilder: () -> MockHttpServletRequestBuilderDelegate): MvcResult {
        return perform(requestBuilder())
    }
}

fun on(mockMvc: MockMvc, requestBuilder: () -> MockHttpServletRequestBuilderDelegate): MvcResult {
    return on(mockMvc).perform(requestBuilder())
}

fun on(mockMvc: MockMvc): MvcRequester {
    return MvcRequester(mockMvc)
}