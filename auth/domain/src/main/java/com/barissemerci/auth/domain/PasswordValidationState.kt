package com.barissemerci.auth.domain

data class PasswordValidationState (
    val hasMinimumLength : Boolean = false,
    val hasNumber : Boolean = false,
    val hasLowercaseCharacter : Boolean = false,
    val hasUppercaseCharacter : Boolean = false,
){
    val isValidPassword : Boolean
        get() = hasMinimumLength && hasNumber && hasLowercaseCharacter && hasUppercaseCharacter
}