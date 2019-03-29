package com.underkode.spring.test.web.servlet.request

import org.springframework.core.io.ClassPathResource
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder

/**
 * Set content from classpath resources.
 * @param filePath classpath of file
 */
fun MockHttpServletRequestBuilder.contentFromResource(filePath: String): MockHttpServletRequestBuilder {
    return content(ClassPathResource(filePath).file.readBytes())
}

