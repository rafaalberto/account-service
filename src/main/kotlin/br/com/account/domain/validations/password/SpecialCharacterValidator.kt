package br.com.account.domain.validations.password

class SpecialCharacterValidator : PasswordValidator {
    override fun isValid(password: String): Boolean {
        return password.matches(Regex(".*[!@#$%^&*()\\-+].*"))
    }
}