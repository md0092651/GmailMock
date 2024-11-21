package com.coroutinelab.presentation.emaillist

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.coroutinelab.core.error.Failure
import com.coroutinelab.domain.model.emaillist.EmailListItemModel
import com.coroutinelab.presentation.emaillist.mvi.EmailListContract

class EmailListScreenTest {

    @Preview
    @Composable
    fun EmailListLoadingScreenPreview() {
        EmailListScreen(
            state = EmailListContract.EmailListState.Loading,
            dispatch = {}
        )
    }

    @Preview
    @Composable
    fun EmailListErrorScreenPreview() {
        EmailListScreen(
            state = EmailListContract.EmailListState.Error(
                Failure.ServerError(500, "Error")
            ),
            dispatch = {}
        )
    }

    @Preview
    @Composable
    fun EmailListListScreenPreview() {
        EmailListScreen(
            state = EmailListContract.EmailListState.Success(
                listOf(
                    EmailListItemModel(
                        id = "2",
                        from = "test@example.com",
                        subject = "Test Subject 2",
                        snippet = "Test Snippet",
                        isStarred = false,
                        date = "o",
                        profileImage = "",
                        isPromotional = false,
                        isImportant = true
                    )
                )
            ),
            dispatch = {}
        )
    }
}
