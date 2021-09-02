package design_patterns

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ChainOfResponsibilityTest {

    @Test
    fun `Chain Of Responsibility`() {
        //create chain elements
        val authenticationHeader = AuthenticationHeader("123456")
        val contentTypeHeader = ContentTypeHeader("json")
        val messageBody = BodyPayload("Body:\n{\n\"username\"=\"dbacinski\"\n}")

        //construct chain
        authenticationHeader.next = contentTypeHeader
        contentTypeHeader.next = messageBody

        //execute chain
        val messageWithAuthentication = authenticationHeader.addHeader("Headers with Authentication:\n")

        println(messageWithAuthentication)

        val messageWithoutAuth = contentTypeHeader.addHeader("Headers without Authentication:\n")
        println(messageWithoutAuth)

        assertThat(messageWithAuthentication).isEqualTo(
            """
                Headers with Authentication:
                Authorization: Bearer 123456
                ContentType: json
                Body:
                {
                "username"="dbacinski"
                }
            """.trimIndent()
        )

        assertThat(messageWithoutAuth).isEqualTo(
            """
                Headers without Authentication:
                ContentType: json
                Body:
                {
                "username"="dbacinski"
                }
            """.trimIndent()
        )
    }
}