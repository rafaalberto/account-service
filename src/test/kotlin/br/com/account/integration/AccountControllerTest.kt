package br.com.account.integration

import br.com.account.api.request.AccountRequest
import com.google.gson.Gson
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.postForEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AccountControllerTest {

    private val url = "http://localhost:8080/account"

    private lateinit var testRestTemplate: TestRestTemplate

    @BeforeAll
    fun setUp() {
        testRestTemplate = TestRestTemplate()
    }

    @Test
    fun `should create account successfully`() {
        val jsonRequest = """
            {
            	"fullName": "Rafael",
            	"email": "rafael.alberto1703@gmail.com",
            	"password": "Ra!12efoi",
            	"confirmPassword": "Ra!12efoi",
            	"active": true
            }
        """.trimIndent()
        val response = doPost(jsonRequest, AccountRequest::class.java)
        Assertions.assertEquals(HttpStatus.OK, response.statusCode)
        Assertions.assertEquals("""{"status":"ok"}""", response.body)
    }

    @Test
    fun `should deny to create account when password is invalid`() {
        val jsonRequest = """
            {
            	"fullName": "Rafael",
            	"email": "rafael.alberto1703@gmail.com",
            	"password": "123",
            	"confirmPassword": "123",
            	"active": true
            }
        """.trimIndent()
        val response = doPost(jsonRequest, AccountRequest::class.java)
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.statusCode)
        Assertions.assertEquals("""{"message":"Invalid password"}""", response.body)
    }

    @Test
    fun `should deny to create account when password and confirm password are different`() {
        val jsonRequest = """
            {
            	"fullName": "Rafael",
            	"email": "rafael.alberto1703@gmail.com",
            	"password": "Ra!12efoi",
            	"confirmPassword": "123",
            	"active": true
            }
        """.trimIndent()
        val response = doPost(jsonRequest, AccountRequest::class.java)
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.statusCode)
        Assertions.assertEquals("""{"message":"Password and Confirm Password must be equal"}""", response.body)
    }

    private fun doPost(json: String, typeOfClass: Class<AccountRequest>): ResponseEntity<String> =
        testRestTemplate.postForEntity(url, Gson().fromJson(json, typeOfClass), String::class)

}