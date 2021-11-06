package br.com.account.api.request

import br.com.account.domain.entity.Account

data class AccountRequest(
    val fullName: String,
    val email: String,
    val password: String,
    val confirmPassword: String,
    var active: Boolean = true
)

fun AccountRequest.asDomainModel(): Account {
    return Account(
        fullName = fullName,
        email = email,
        password = password,
        confirmPassword = confirmPassword,
        active = active
    )
}
