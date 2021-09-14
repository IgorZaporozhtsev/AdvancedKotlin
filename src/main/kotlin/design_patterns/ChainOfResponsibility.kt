package design_patterns

import java.lang.IllegalStateException
/**
 * follow to the test package
 * по сути выглядит как LinkedList с Нодами которые имеют ссылку на след ноду
 *
 *
 * */

interface HeadersChain {
    fun addHeader(inputHeader: String): String
}

class AuthenticationHeader(
    private val token: String?,
    var next: HeadersChain? = null
): HeadersChain {
    override fun addHeader(inputHeader: String): String {
        token ?: throw IllegalStateException("Token should be not null")
//        return inputHeader + "Authorization: Bearer $token\n"
//            .let { next?.addHeader(it) ?: it }

       return next?.addHeader(inputHeader + "Authorization: Bearer $token\n")!!
    }
}

class ContentTypeHeader(
    val contentType: String,
    var next: HeadersChain? = null
) : HeadersChain {

    override fun addHeader(inputHeader: String): String =
        inputHeader + "ContentType: $contentType\n"
            .let { next?.addHeader(it) ?: it }
}

class BodyPayload(
    val body: String,
    var next: HeadersChain? = null
) : HeadersChain {
    override fun addHeader(inputHeader: String): String =
        inputHeader + body
            .let { next?.addHeader(it) ?: it }
    //inputHeader + body + next.addHeader(inputHeader)
}




