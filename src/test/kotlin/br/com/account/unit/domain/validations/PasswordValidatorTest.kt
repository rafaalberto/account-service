package br.com.account.unit.domain.validations

import br.com.account.domain.validations.*
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PasswordValidatorTest {

    private lateinit var passwordValidator: PasswordValidator

    @Test
    fun `should validate digit success`() {
        passwordValidator = DigitValidator()
        Assertions.assertEquals(true, passwordValidator.isValid("ab4"))
    }

    @Test
    fun `should validate digit error`() {
        passwordValidator = DigitValidator()
        Assertions.assertEquals(false, passwordValidator.isValid("abc"))
    }

    @Test
    fun `should validate length success`() {
        passwordValidator = LengthValidator()
        Assertions.assertEquals(true, passwordValidator.isValid("abcdefghi9"))
    }

    @Test
    fun `should validate length error`() {
        passwordValidator = LengthValidator()
        Assertions.assertEquals(false, passwordValidator.isValid("abcdefgh"))
    }

    @Test
    fun `should validate lowercase success`() {
        passwordValidator = LowercaseLetterValidator()
        Assertions.assertEquals(true, passwordValidator.isValid("aBc"))
    }

    @Test
    fun `should validate lowercase error`() {
        passwordValidator = LowercaseLetterValidator()
        Assertions.assertEquals(false, passwordValidator.isValid("A12"))
    }

    @Test
    fun `should validate uppercase success`() {
        passwordValidator = UppercaseLetterValidator()
        Assertions.assertEquals(true, passwordValidator.isValid("12Bc"))
    }

    @Test
    fun `should validate uppercase error`() {
        passwordValidator = UppercaseLetterValidator()
        Assertions.assertEquals(false, passwordValidator.isValid("12bc"))
    }

    @Test
    fun `should validate special character success`() {
        passwordValidator = SpecialCharacterValidator()
        Assertions.assertEquals(true, passwordValidator.isValid("12#@!"))
    }

    @Test
    fun `should validate special character error`() {
        passwordValidator = SpecialCharacterValidator()
        Assertions.assertEquals(false, passwordValidator.isValid("12~`'"))
    }

    @Test
    fun `should validate space success`() {
        passwordValidator = SpaceValidator()
        Assertions.assertEquals(true, passwordValidator.isValid("12#@!"))
    }

    @Test
    fun `should validate space error`() {
        passwordValidator = SpaceValidator()
        Assertions.assertEquals(false, passwordValidator.isValid("12a bd"))
    }

    @Test
    fun `should validate repeat character success`() {
        passwordValidator = RepeatedCharacterValidator()
        Assertions.assertEquals(true, passwordValidator.isValid("Abc123"))
    }

    @Test
    fun `should validate repeat character error`() {
        passwordValidator = RepeatedCharacterValidator()
        Assertions.assertEquals(false, passwordValidator.isValid("aabB123"))
    }

}