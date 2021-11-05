package br.com.account.domain.usecase

import br.com.account.domain.entity.Account
import br.com.account.domain.exception.AccountException
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AccountUseCaseTest {

    private lateinit var accountUseCase: AccountUseCase
    private lateinit var account: Account

    @BeforeAll
    fun setUp() {
        accountUseCase = AccountUseCaseImpl()
        account = Account(
            fullName = "Rafael",
            email = "rafael.alberto1703@gmail.com",
            password = "AbTp9!fok",
            confirmPassword = "AbTp9!fok",
        )
    }

    @Test
    fun `should create account successfully`() {
        accountUseCase.validateAccount(account)
        Assertions.assertEquals(true, account.active)
    }

    @Test
    fun `should throw error when try to create inactive account`() {
        val accountToCreate = account.copy(active = false)
        val exception = Assertions.assertThrows(AccountException::class.java) {
            accountUseCase.validateAccount(accountToCreate)
        }
        Assertions.assertEquals("Account should be active", exception.description)
    }

    @Test
    fun `should throw error when try to create password and confirm password different`() {
        val accountToCreate = account.copy(confirmPassword = "123")
        val exception = Assertions.assertThrows(AccountException::class.java) {
            accountUseCase.validateAccount(accountToCreate)
        }
        Assertions.assertEquals("Password and Confirm Password must be equal", exception.description)
    }

}