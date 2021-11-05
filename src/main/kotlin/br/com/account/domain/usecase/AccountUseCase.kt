package br.com.account.domain.usecase

import br.com.account.domain.entity.Account

interface AccountUseCase {

    fun validateAccount(account: Account)

}