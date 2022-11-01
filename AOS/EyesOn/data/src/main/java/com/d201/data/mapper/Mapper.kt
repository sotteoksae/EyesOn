package com.d201.data.mapper

import com.d201.data.model.response.AngelInfoResponse
import com.d201.data.model.response.LoginResponse
import com.d201.data.model.response.UserResponse
import com.d201.domain.model.AngelInfo
import com.d201.domain.model.Login
import com.d201.domain.model.User

fun UserResponse.mapperToUser(): User {
    return this.let {
        User(
            it.accessToken,
            it.refreshToken,
            it.userSeq,
            it.userName,
            it.userEmail,
            it.status
        )
    }
}

fun LoginResponse.mapperToToken(): Login{
    return this.let {
        Login(
            it.token,
            it.role,
            it.gender
        )
    }
}

fun AngelInfoResponse.mapperToAngelInfo(): AngelInfo{
    return this.let {
        AngelInfo(
            it.alarmStart,
            it.alarmEnd,
            it.alarmDay,
            it.compCnt,
            it.helpCnt,
            it.gender,
            it.active,
        )
    }
}