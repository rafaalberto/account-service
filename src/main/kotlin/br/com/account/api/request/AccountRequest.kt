package br.com.account.api.request

data class AccountRequest(
    val fullName: String,
    val email: String,
    val password: String,
    val confirmPassword: String,
    var active: Boolean = true
)
