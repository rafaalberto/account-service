package br.com.account.domain.usecase

import br.com.account.domain.entity.Account
import br.com.account.domain.exception.AccountException

class AccountUseCaseImpl : AccountUseCase {
    override fun createAccount(account: Account) {
        validateAccount(account)
    }

    private fun validateAccount(account: Account) {
        if (!account.active) {
            throw AccountException("Account should be active")
        }
    }

}