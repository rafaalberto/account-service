package br.com.account.domain.validations.password

class DigitValidator : PasswordValidator {
    override fun isValid(password: String): Boolean {
        return password.matches(Regex(".*\\d.*"))
    }
}