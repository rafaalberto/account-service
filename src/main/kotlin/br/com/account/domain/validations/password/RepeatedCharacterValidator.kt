package br.com.account.domain.validations.password

class RepeatedCharacterValidator : PasswordValidator {
    override fun isValid(password: String): Boolean {
        return password.matches(Regex(".*[(\\w)\\\\1+\"].*"))
    }
}