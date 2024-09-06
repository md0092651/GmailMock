package com.coroutinelab.domain.usecase.emaillist

import com.coroutinelab.core.error.Failure
import com.coroutinelab.core.functional.Either
import com.coroutinelab.domain.model.emaildetails.EmailDetailsModel
import com.coroutinelab.domain.repository.EmailRepository
import javax.inject.Inject

class GetEmailDetailsUseCase @Inject constructor(
    private val emailRepository: EmailRepository
) {
    suspend operator fun invoke(): Either<Failure, EmailDetailsModel> {
        return emailRepository.getEmailDetails()
    }

}