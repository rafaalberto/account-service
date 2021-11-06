package br.com.account.integration

import br.com.account.api.controller.AccountController
import br.com.account.api.request.AccountRequest
import com.google.gson.Gson
import org.hamcrest.Matchers
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@ExtendWith(SpringExtension::class)
@WebMvcTest(AccountController::class)
class AccountControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var gson: Gson

    @Test
    fun `should create account successfully`() {
        mockMvc.perform(
            MockMvcRequestBuilders.post("/account")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    gson.toJson(
                        AccountRequest(
                            fullName = "Rafael",
                            email = "rafael.alberto1703@gmail.com",
                            password = "Ra!12efoi",
                            confirmPassword = "Ra!12efoi",
                            active = true
                        )
                    )
                )
        )
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.jsonPath("$.status", Matchers.`is`("ok")))
            .andDo(MockMvcResultHandlers.print())
    }

    @Test
    fun `should throw error when try to create account with invalid password`() {
        mockMvc.perform(
            MockMvcRequestBuilders.post("/account")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    gson.toJson(
                        AccountRequest(
                            fullName = "Rafael",
                            email = "rafael.alberto1703@gmail.com",
                            password = "Ra!12ef",
                            confirmPassword = "Ra!12efoi",
                            active = true
                        )
                    )
                )
        )
            .andExpect(MockMvcResultMatchers.status().isBadRequest)
            .andExpect(MockMvcResultMatchers.jsonPath("$.message", Matchers.`is`("Invalid password")))
            .andDo(MockMvcResultHandlers.print())
    }

}