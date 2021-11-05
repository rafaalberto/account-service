package br.com.account.domain.entity

data class Account(
    val fullName: String,
    val email: String,
    val password: String,
    val confirmPassword: String,
    var active: Boolean = true
)
