package io.inkode.spring.test.web.servlet.request

import org.springframework.http.HttpMethod
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.RequestBuilder
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import java.net.URI

/**
 * Create a [MockHttpServletRequestBuilder] for a GET request.
 * @param urlTemplate a URL template; the resulting URL will be encoded
 * @param uriVars zero or more URI variables
 */
fun get(
    urlTemplate: String,
    vararg uriVars: Any,
    init: MockHttpServletRequestBuilder.() -> Unit = {}
): MockHttpServletRequestBuilder =
    initAndReturn(init, MockMvcRequestBuilders.get(urlTemplate, *uriVars))

/**
 * Create a [MockHttpServletRequestBuilder] for a GET request.
 * @param uri the URL
 */
fun get(
    uri: URI,
    init: MockHttpServletRequestBuilder.() -> Unit = {}
): MockHttpServletRequestBuilder =
    initAndReturn(init, MockMvcRequestBuilders.get(uri))

/**
 * Create a [MockHttpServletRequestBuilder] for a POST request.
 * @param urlTemplate a URL template; the resulting URL will be encoded
 * @param uriVars zero or more URI variables
 */
fun post(
    urlTemplate: String, vararg uriVars: Any,
    init: MockHttpServletRequestBuilder.() -> Unit = {}
): MockHttpServletRequestBuilder =
    initAndReturn(init, MockMvcRequestBuilders.post(urlTemplate, *uriVars))

/**
 * Create a [MockHttpServletRequestBuilder] for a POST request.
 * @param uri the URL
 */
fun post(
    uri: URI,
    init: MockHttpServletRequestBuilder.() -> Unit = {}
): MockHttpServletRequestBuilder =
    initAndReturn(init, MockMvcRequestBuilders.post(uri))

/**
 * Create a [MockHttpServletRequestBuilder] for a PUT request.
 * @param urlTemplate a URL template; the resulting URL will be encoded
 * @param uriVars zero or more URI variables
 */
fun put(
    urlTemplate: String, vararg uriVars: Any,
    init: MockHttpServletRequestBuilder.() -> Unit = {}
): MockHttpServletRequestBuilder =
    initAndReturn(init, MockMvcRequestBuilders.put(urlTemplate, *uriVars))

/**
 * Create a [MockHttpServletRequestBuilder] for a PUT request.
 * @param uri the URL
 */
fun put(
    uri: URI,
    init: MockHttpServletRequestBuilder.() -> Unit = {}
): MockHttpServletRequestBuilder =
    initAndReturn(init, MockMvcRequestBuilders.put(uri))

/**
 * Create a [MockHttpServletRequestBuilder] for a PATCH request.
 * @param urlTemplate a URL template; the resulting URL will be encoded
 * @param uriVars zero or more URI variables
 */
fun patch(
    urlTemplate: String, vararg uriVars: Any,
    init: MockHttpServletRequestBuilder.() -> Unit = {}
): MockHttpServletRequestBuilder =
    initAndReturn(init, MockMvcRequestBuilders.patch(urlTemplate, *uriVars))

/**
 * Create a [MockHttpServletRequestBuilder] for a PATCH request.
 * @param uri the URL
 */
fun patch(
    uri: URI,
    init: MockHttpServletRequestBuilder.() -> Unit = {}
): MockHttpServletRequestBuilder =
    initAndReturn(init, MockMvcRequestBuilders.patch(uri))

/**
 * Create a [MockHttpServletRequestBuilder] for a DELETE request.
 * @param urlTemplate a URL template; the resulting URL will be encoded
 * @param uriVars zero or more URI variables
 */
fun delete(
    urlTemplate: String, vararg uriVars: Any,
    init: MockHttpServletRequestBuilder.() -> Unit = {}
): MockHttpServletRequestBuilder =
    initAndReturn(init, MockMvcRequestBuilders.delete(urlTemplate, *uriVars))

/**
 * Create a [MockHttpServletRequestBuilder] for a DELETE request.
 * @param uri the URL
 */
fun delete(
    uri: URI,
    init: MockHttpServletRequestBuilder.() -> Unit = {}
): MockHttpServletRequestBuilder =
    initAndReturn(init, MockMvcRequestBuilders.delete(uri))

/**
 * Create a [MockHttpServletRequestBuilder] for an OPTIONS request.
 * @param urlTemplate a URL template; the resulting URL will be encoded
 * @param uriVars zero or more URI variables
 */
fun options(
    urlTemplate: String, vararg uriVars: Any,
    init: MockHttpServletRequestBuilder.() -> Unit = {}
): MockHttpServletRequestBuilder =
    initAndReturn(init, MockMvcRequestBuilders.options(urlTemplate, *uriVars))

/**
 * Create a [MockHttpServletRequestBuilder] for an OPTIONS request.
 * @param uri the URL
 */
fun options(
    uri: URI,
    init: MockHttpServletRequestBuilder.() -> Unit = {}
): MockHttpServletRequestBuilder =
    initAndReturn(init, MockMvcRequestBuilders.options(uri))

/**
 * Create a [MockHttpServletRequestBuilder] for a HEAD request.
 * @param urlTemplate a URL template; the resulting URL will be encoded
 * @param uriVars zero or more URI variables
 */
fun head(
    urlTemplate: String, vararg uriVars: Any,
    init: MockHttpServletRequestBuilder.() -> Unit = {}
): MockHttpServletRequestBuilder =
    initAndReturn(init, MockMvcRequestBuilders.head(urlTemplate, *uriVars))

/**
 * Create a [MockHttpServletRequestBuilder] for a HEAD request.
 * @param uri the URL
 */
fun head(
    uri: URI,
    init: MockHttpServletRequestBuilder.() -> Unit = {}
): MockHttpServletRequestBuilder =
    initAndReturn(init, MockMvcRequestBuilders.head(uri))

/**
 * Create a [MockHttpServletRequestBuilder] for a request with the given HTTP method.
 * @param method the HTTP method (GET, POST, etc)
 * @param urlTemplate a URL template; the resulting URL will be encoded
 * @param uriVars zero or more URI variables
 */
fun request(
    method: HttpMethod, urlTemplate: String, vararg uriVars: Any,
    init: MockHttpServletRequestBuilder.() -> Unit = {}
): MockHttpServletRequestBuilder = initAndReturn(
    init,
    MockMvcRequestBuilders.request(method, urlTemplate, uriVars)
)

/**
 * Create a [MockHttpServletRequestBuilder] for a request with the given HTTP method.
 * @param httpMethod the HTTP method (GET, POST, etc)
 * @param uri the URL
 */
fun request(
    httpMethod: HttpMethod, uri: URI,
    init: MockHttpServletRequestBuilder.() -> Unit = {}
): MockHttpServletRequestBuilder =
    initAndReturn(init, MockMvcRequestBuilders.request(httpMethod, uri))

/**
 * Alternative factory method that allows for custom HTTP verbs (e.g. WebDAV).
 * @param httpMethod the HTTP method
 * @param uri the URL
 */
fun request(
    httpMethod: String, uri: URI,
    init: MockHttpServletRequestBuilder.() -> Unit = {}
): MockHttpServletRequestBuilder =
    initAndReturn(init, MockMvcRequestBuilders.request(httpMethod, uri))

/**
 * Create a [MockMultipartHttpServletRequestBuilder] for a multipart request.
 * @param urlTemplate a URL template; the resulting URL will be encoded
 * @param uriVars zero or more URI variables
 */
fun multipart(
    urlTemplate: String, vararg uriVars: Any,
    init: MockMultipartHttpServletRequestBuilder.() -> Unit = {}
): MockMultipartHttpServletRequestBuilder = initAndReturn(
    init,
    MockMvcRequestBuilders.multipart(urlTemplate, *uriVars)
)

/**
 * Create a [MockMultipartHttpServletRequestBuilder] for a multipart request.
 * @param uri the URL
 */
fun multipart(
    uri: URI,
    init: MockHttpServletRequestBuilder.() -> Unit = {}
): MockMultipartHttpServletRequestBuilder =
    initAndReturn(init, MockMvcRequestBuilders.multipart(uri))

/**
 * Init a [RequestBuilder] and return initialized request.
 * @param init
 * @param requestBuilder
 */
private fun <T : RequestBuilder> initAndReturn(
    init: T.() -> Unit,
    requestBuilder: T
): T {
    init(requestBuilder)

    return requestBuilder
}

/**
 * Create a [RequestBuilder] for an async dispatch from the
 * [MvcResult] of the request that started async processing.
 *
 * Usage involves performing a request that starts async processing first:
 * <pre class="code">
 * MvcResult mvcResult = this.mockMvc.perform(get("/1"))
 * .andExpect(request().asyncStarted())
 * .andReturn();
</pre> *
 *
 * And then performing the async dispatch re-using the `MvcResult`:
 * <pre class="code">
 * this.mockMvc.perform(asyncDispatch(mvcResult))
 * .andExpect(status().isOk())
 * .andExpect(content().contentType(MediaType.APPLICATION_JSON))
 * .andExpect(content().string("{\"name\":\"Joe\",\"someDouble\":0.0,\"someBoolean\":false}"));
</pre> *
 * @param mvcResult the result from the request that started async processing
 */
fun asyncDispatch(mvcResult: MvcResult): RequestBuilder {
    // There must be an async result before dispatching
    mvcResult.asyncResult

    return MockMvcRequestBuilders.asyncDispatch(mvcResult)
}

