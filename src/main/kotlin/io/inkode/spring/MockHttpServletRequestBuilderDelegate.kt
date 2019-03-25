package io.inkode.spring

import org.springframework.core.io.ClassPathResource
import org.springframework.http.MediaType
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.mock.web.MockHttpServletRequest
import org.springframework.test.web.servlet.RequestBuilder
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import javax.servlet.ServletContext

/**
 * @author Maxim Seredkin
 */
class MockHttpServletRequestBuilderDelegate(private val requestBuilder: MockHttpServletRequestBuilder) :
    RequestBuilder {
    object Config {
        var contentTypeValue: MediaType = APPLICATION_JSON
    }

    init {
        requestBuilder.contentType(Config.contentTypeValue.toString())
    }

    fun contentType(contentType: MediaType) {
        requestBuilder.contentType(contentType)
    }

    fun contentType(contentType: String) {
        requestBuilder.contentType(contentType)
    }

    fun param(paramName: String, vararg paramValues: String): MockHttpServletRequestBuilderDelegate {
        requestBuilder.param(paramName, *paramValues)

        return this
    }

    fun bodyFromResource(filePath: String) {
        requestBuilder.content(ClassPathResource(filePath).file.readBytes())
    }

    fun body(content: String) {
        requestBuilder.content(content)
    }

    override fun buildRequest(servletContext: ServletContext): MockHttpServletRequest {
        return requestBuilder.buildRequest(servletContext)
    }
}

/**
 * Get-request
 *
 * @param pathTemplate  path template of request
 * @param pathVars      variables for path template
 * @param init          request initialization
 */
fun get(
    pathTemplate: String,
    vararg pathVars: Any,
    init: MockHttpServletRequestBuilderDelegate.() -> Unit = {}
): MockHttpServletRequestBuilderDelegate {
    val mvcRequestBuilder = MockHttpServletRequestBuilderDelegate(MockMvcRequestBuilders.get(pathTemplate, *pathVars))

    init(mvcRequestBuilder)

    return mvcRequestBuilder
}

/**
 * Post-request
 *
 * @param pathTemplate  path template of request
 * @param pathVars      variables for path template
 * @param init          request initialization
 */
fun post(
    pathTemplate: String,
    vararg pathVars: Any,
    init: MockHttpServletRequestBuilderDelegate.() -> Unit = {}
): MockHttpServletRequestBuilderDelegate {
    val mvcRequestBuilder = MockHttpServletRequestBuilderDelegate(MockMvcRequestBuilders.post(pathTemplate, *pathVars))

    init(mvcRequestBuilder)

    return mvcRequestBuilder
}