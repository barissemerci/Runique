package com.barissemerci.auth.domain

interface PatternValidator {
    fun matches(value: String) : Boolean
}