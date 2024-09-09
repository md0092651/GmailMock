package com.coroutinelab.domain.usecase.emaildetails

import com.coroutinelab.core.error.Failure
import com.coroutinelab.core.functional.Either
import com.coroutinelab.domain.model.emaillist.EmailListItemModel
import com.coroutinelab.domain.repository.EmailRepository
import javax.inject.Inject

class GetEmailsUseCase
    @Inject
    constructor(
        private val emailRepository: EmailRepository
    ) {
        suspend operator fun invoke(): Either<Failure, List<EmailListItemModel>> = emailRepository.getEmailList()
    }
