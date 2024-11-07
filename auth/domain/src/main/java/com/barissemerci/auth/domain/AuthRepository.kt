package com.barissemerci.auth.domain

import com.barissemerci.core.domain.util.DataError
import com.barissemerci.core.domain.util.EmptyDataResult

interface AuthRepository {
    suspend fun login(email: String, password: String): EmptyDataResult<DataError.Network>
    suspend fun register(email: String, password: String): EmptyDataResult<DataError.Network>
}