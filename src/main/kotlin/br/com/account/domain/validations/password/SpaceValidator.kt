package br.com.account.domain.validations.password

class SpaceValidator : PasswordValidator {
    override fun isValid(password: String): Boolean {
        return password.matches(Regex("[^\\ ]+"))
    }
}