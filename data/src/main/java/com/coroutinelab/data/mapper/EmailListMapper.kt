package com.coroutinelab.data.mapper

import com.coroutinelab.core.functional.mapOrDefault
import com.coroutinelab.core.functional.orDefault
import com.coroutinelab.core.mapper.ResultMapper
import com.coroutinelab.data.dto.emaillist.EmailListDto
import com.coroutinelab.data.dto.emaillist.EmailListItem
import com.coroutinelab.domain.model.common.FileInfo
import com.coroutinelab.domain.model.emaillist.EmailListItemModel
import javax.inject.Inject

class EmailListMapper @Inject constructor(): ResultMapper<EmailListDto, List<EmailListItemModel>> {

    override fun map(input: EmailListDto): List<EmailListItemModel> = input.filter {
        it.id != null && it.payload.from != null
    }.map {
        it.toEmailListItemModel()
    }

    private fun EmailListItem.toEmailListItemModel() = EmailListItemModel(
        id = id!!,
        from = payload.from!!,
        profileImage = payload.profileImage,
        subject = payload.subject.orEmpty(),
        snippet = snippet.orEmpty(),
        date = payload.date.orEmpty(),
        isImportant = isImportant.orDefault(),
        isStarred = isImportant.orDefault(),
        isPromotional = isPromotional.orDefault(),
        fileInfo = payload.attachments.mapOrDefault(emptyList()) { attachment ->
            FileInfo(
                filename = attachment.filename.orEmpty(),
                mimeType = attachment.mimeType.orEmpty()
            )
        }
    )

}


