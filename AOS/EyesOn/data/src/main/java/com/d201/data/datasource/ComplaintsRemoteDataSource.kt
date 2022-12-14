package com.d201.data.datasource

import com.d201.data.api.ComplaintsApi
import com.d201.data.model.request.ComplaintsRequest
import com.d201.data.model.response.ComplaintsResponse
import com.d201.domain.base.BaseResponse
import com.d201.domain.model.PagingResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okhttp3.MultipartBody
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ComplaintsRemoteDataSource @Inject constructor(private val complaintsApi: ComplaintsApi) {

    fun insertComp(
        complaintsRequest: MultipartBody.Part,
        imageFile: MultipartBody.Part
    ): Flow<BaseResponse<Boolean>> = flow {
        emit(complaintsApi.insertComp(complaintsRequest, imageFile))
    }

    fun selectComplaintsBySeq(seq: Long): Flow<BaseResponse<ComplaintsResponse>> = flow {
        emit(complaintsApi.selectComplaintsBySeq(seq))
    }

    fun returnComplaints(complaintsRequest: ComplaintsRequest): Flow<BaseResponse<Void>> = flow {
        emit(complaintsApi.returnComplaints(complaintsRequest))
    }

    fun submitComplaints(complaintsRequest: ComplaintsRequest): Flow<BaseResponse<Void>> = flow {
        emit(complaintsApi.submitComplaints(complaintsRequest))
    }

    fun completeComplaints(complaintsRequest: ComplaintsRequest): Flow<BaseResponse<Void>> = flow {
        emit(complaintsApi.completeComplaints(complaintsRequest))
    }

    fun selectComplaintsList(
        flag: Int,
        page: Int,
        size: Int
    ): Flow<BaseResponse<PagingResult<ComplaintsResponse>>> = flow {
        emit(complaintsApi.selectComplaintsList(flag, page, size))
    }

}