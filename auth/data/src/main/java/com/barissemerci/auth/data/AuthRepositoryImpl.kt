package com.barissemerci.auth.data

import com.barissemerci.auth.domain.AuthRepository
import com.barissemerci.core.data.networking.post
import com.barissemerci.core.domain.AuthInfo
import com.barissemerci.core.domain.SessionStorage
import com.barissemerci.core.domain.util.DataError
import com.barissemerci.core.domain.util.EmptyDataResult
import com.barissemerci.core.domain.util.Result
import com.barissemerci.core.domain.util.asEmptyDataResult
import io.ktor.client.HttpClient

class AuthRepositoryImpl(
    val httpClient: HttpClient,
    private val sessionStorage: SessionStorage
) : AuthRepository {
    override suspend fun login(
        email: String,
        password: String
    ): EmptyDataResult<DataError.Network> {
        val result = httpClient.post<LoginRequest, LoginResponse>(
            route = "/login",
            body = LoginRequest(
                email = email,
                password = password
            )
        )
        if(result is Result.Success){
            sessionStorage.set(
                authInfo = AuthInfo(
                    accessToken = result.data.accessToken,
                    refreshToken = result.data.refreshToken,
                    userId = result.data.userId
                )
            )
        }
        return result.asEmptyDataResult()
    }


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