package com.coroutinelab.domain.usecase.emaildetails

import com.coroutinelab.domain.respository.EmailRepository
import javax.inject.Inject

class EmailDetailsUseCase @Inject constructor(private val repository: EmailRepository) {
    suspend operator fun invoke() = repository.getEmailDetails()
}