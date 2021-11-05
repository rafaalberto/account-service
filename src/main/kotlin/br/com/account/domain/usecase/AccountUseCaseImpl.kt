package br.com.account.domain.usecase

import br.com.account.domain.entity.Account
import br.com.account.domain.exception.AccountException
import br.com.account.domain.validations.*
import br.com.account.domain.validations.password.*

class AccountUseCaseImpl : AccountUseCase {
    override fun createAccount(account: Account) {
        validateAccount(account)
    }

    private fun validateAccount(account: Account) {
        if (!account.active) {
            throw AccountException("Account should be active")
        }
        validatePassword(account.password)
        if (account.password !== account.confirmPassword) {
            throw AccountException("Password and Confirm Password must be equal")
        }
    }

    private fun validatePassword(password: String) {
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
            if (!it.isValid(password))
                throw AccountException("Invalid password")
        }
    }
}