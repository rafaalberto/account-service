package br.com.account.domain.usecase

import br.com.account.domain.entity.Account

interface AccountUseCase {

    fun createAccount(account: Account)

}