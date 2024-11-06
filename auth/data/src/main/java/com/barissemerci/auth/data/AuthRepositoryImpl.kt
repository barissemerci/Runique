package com.barissemerci.auth.data

import com.barissemerci.auth.domain.AuthRepository
import com.barissemerci.core.data.networking.post
import com.barissemerci.core.domain.util.DataError
import com.barissemerci.core.domain.util.EmptyDataResult
import io.ktor.client.HttpClient

class AuthRepositoryImpl(
    val httpClient: HttpClient
) : AuthRepository {
    override suspend fun register(
        email: String,
        password: String
    ): EmptyDataResult<DataError.Network> {
        return httpClient.post<RegisterRequest, Unit>( //given request model and expected response model, in this case Unit. (we don't expect any response)
            route = "/register",
            body = RegisterRequest(
                email = email,
                password = password
            )
        )
    }
}