package br.com.account.domain.validations

class DigitValidator : PasswordValidator {
    override fun isValid(password: String) = password.matches(Regex(".*\\d.*"))
}

class LengthValidator : PasswordValidator {
    override fun isValid(password: String) = password.length >= 9
}

class LowercaseLetterValidator : PasswordValidator {
    override fun isValid(password: String) = password.matches(Regex(".*[a-z].*"))
}

class SpaceValidator : PasswordValidator {
    override fun isValid(password: String) = password.matches(Regex("[^ ]+"))
}

class SpecialCharacterValidator : PasswordValidator {
    override fun isValid(password: String) = password.matches(Regex(".*[!@#$%^&*()\\-+].*"))
}

class UppercaseLetterValidator : PasswordValidator {
    override fun isValid(password: String) = password.matches(Regex(".*[A-Z].*"))
}

class RepeatedCharacterValidator : PasswordValidator {
    override fun isValid(password: String) = !password.contains(Regex("(.)(?=(.*)\\1)"))
}

