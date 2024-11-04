package com.barissemerci.auth.domain

class UserDataValidator(private val patternValidator: PatternValidator) {
    fun isValidEmail(email: String): Boolean {
        return patternValidator.matches(email.trim())
    }

    fun validatePassword(password: String): PasswordValidationState {
        val hasMinLength = password.length >= MIN_PASSWORD_LENGTH
        val hasDigit = password.any { it.isDigit() }
        val hasUpperCaseCharacter = password.any { it.isUpperCase() }
        val hasLowerCaseCharacter = password.any { it.isLowerCase() }
        return PasswordValidationState(
            hasMinimumLength = hasMinLength,
            hasNumber = hasDigit,
            hasUppercaseCharacter = hasUpperCaseCharacter,
            hasLowercaseCharacter = hasLowerCaseCharacter,
        )

    }

    companion object {
        const val MIN_PASSWORD_LENGTH = 9
    }
}