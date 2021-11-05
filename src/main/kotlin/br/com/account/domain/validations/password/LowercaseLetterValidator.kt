package br.com.account.domain.validations.password

class LowercaseLetterValidator : PasswordValidator {
    override fun isValid(password: String): Boolean {
        return password.matches(Regex(".*[a-z].*"))
    }
}