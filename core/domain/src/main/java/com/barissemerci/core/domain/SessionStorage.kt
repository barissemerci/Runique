package com.barissemerci.core.domain

interface SessionStorage {
    suspend fun set(authInfo: AuthInfo?)
    suspend fun get() : AuthInfo?
}