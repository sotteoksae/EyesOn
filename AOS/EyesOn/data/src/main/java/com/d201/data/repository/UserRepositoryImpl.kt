package com.d201.data.repository

import com.d201.data.datasource.UserRemoteDataSource
import com.d201.data.mapper.mapperToToken
import com.d201.data.model.request.UserRequest
import com.d201.data.model.response.LoginResponse
import com.d201.domain.base.BaseResponse
import com.d201.domain.model.Login
import com.d201.domain.repository.UserRepository
import com.d201.domain.utils.ResultType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepositoryImpl @Inject constructor(
    private val userRemoteDataSource: UserRemoteDataSource
): UserRepository {

    override fun loginUser(idToken: String, fcmToken: String): Flow<ResultType<BaseResponse<Login>>> = flow {
        emit(ResultType.Loading)
        userRemoteDataSource.loginUser(UserRequest(idToken, fcmToken)).collect {
            emit(ResultType.Success(
                BaseResponse(
                it.message,
                it.status,
                it.data.mapperToToken()
                )))
        }
    }


}