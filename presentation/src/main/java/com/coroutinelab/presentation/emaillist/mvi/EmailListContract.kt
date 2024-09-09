package com.coroutinelab.presentation.emaillist.mvi

import com.coroutinelab.core.error.Failure
import com.coroutinelab.core_ui.mvi.MVIContract
import com.coroutinelab.domain.model.emaillist.EmailListItemModel

interface EmailListContract :
    MVIContract<EmailListContract.EmailListEvent, EmailListContract.EmailListState, EmailListContract.EmailListEffect> {
    sealed class EmailListEvent {
        data object
        LoadEmailList : EmailListEvent()

        data object EmailClicked : EmailListEvent()
    }

    sealed class EmailListState {
        data object Loading : EmailListState()

        data class Success(
            val emailList: List<EmailListItemModel>
        ) : EmailListState()

        data class Error(
            val error: Failure
        ) : EmailListState()
    }

    sealed class EmailListEffect {
        data object NavigateToEmailDetails : EmailListEffect()
    }
}
