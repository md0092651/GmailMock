package com.coroutinelab.data.repository

import com.coroutinelab.core.error.Failure
import com.coroutinelab.core.functional.Either
import com.coroutinelab.data.mapper.EmailDetailsMapper
import com.coroutinelab.data.mapper.EmailListMapper
import com.coroutinelab.data.remote.api.ApiService
import com.coroutinelab.data.remote.handler.safeApiCall
import com.coroutinelab.domain.model.emaillist.EmailListItemModel
import com.coroutinelab.domain.respository.EmailRepository
import javax.inject.Inject

class EmailRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val emailListMapper: EmailListMapper,
    private val emailDetailsMapper: EmailDetailsMapper
) : EmailRepository {
    override suspend fun getEmailList(): Either<Failure, List<EmailListItemModel>> =
        safeApiCall(
            apiCall = { apiService.getEmailList() },
            mapper = { emailListMapper.map(it) }
        )

    override suspend fun getEmailDetails() =
        safeApiCall(
            apiCall = { apiService.getEmailDetail() },
            mapper = { emailDetailsMapper.map(it) }
        )
}
