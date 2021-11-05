package br.com.account.domain.validations.password

class LengthValidator : PasswordValidator {
    override fun isValid(password: String): Boolean {
        return password.length >= 9
    }
}