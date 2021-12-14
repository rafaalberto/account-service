package br.com.account.domain.usecase

import br.com.account.domain.entity.Account
import br.com.account.domain.exception.AccountException
import br.com.account.domain.validations.*
import org.slf4j.LoggerFactory

class AccountUseCaseImpl : AccountUseCase {

    companion object {
        private val logger = LoggerFactory.getLogger(this::class.java)
    }

    override fun createAccount(account: Account) {
        validateFullName(account)
        validateEmail(account)
        validatePassword(account)
        validateConfirmPassword(account)
        validateActive(account)
    }

    private fun validateFullName(account: Account) {
        if (account.fullName == "") {
            throw AccountException("Full name must be informed")
        }
    }

    private fun validateEmail(account: Account) {
        if (account.email == "") {
            throw AccountException("Email must be informed")
        }
    }

    private fun validatePassword(account: Account) {
        val validators = listOf(
            LengthValidator(),
            DigitValidator(),
            LowercaseLetterValidator(),
            UppercaseLetterValidator(),
            SpecialCharacterValidator(),
            SpaceValidator(),
            RepeatedCharacterValidator()
        )
        validators.forEach {
            if (!it.isValid(account.password)) {
                logger.error("password error")
                throw AccountException("Invalid password")
            }
        }
    }

    private fun validateConfirmPassword(account: Account) {
        if (account.password != account.confirmPassword) {
            throw AccountException("Password and Confirm Password must be equal")
        }
    }

    private fun validateActive(account: Account) {
        if (!account.active) {
            throw AccountException("Account should be active")
        }
    }

}