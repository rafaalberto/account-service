package br.com.account.domain.validations.password

interface PasswordValidator {

    fun isValid(password: String) : Boolean

}