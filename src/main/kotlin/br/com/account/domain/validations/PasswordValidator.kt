package br.com.account.domain.validations

interface PasswordValidator {
    fun isValid(password: String) : Boolean
}