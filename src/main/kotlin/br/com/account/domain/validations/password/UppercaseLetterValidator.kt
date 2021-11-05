package br.com.account.domain.validations.password

class UppercaseLetterValidator : PasswordValidator {
    override fun isValid(password: String): Boolean {
        return password.matches(Regex(".*[A-Z].*"))
    }
}