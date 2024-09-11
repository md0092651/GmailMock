package com.coroutinelab.presentation.emaillist.mvi

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coroutinelab.core.functional.fold
import com.coroutinelab.domain.usecase.emaildetails.GetEmailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EmailListViewModel @Inject constructor(
    private val getEmailsUseCase: GetEmailsUseCase
) : ViewModel(), EmailListContract {
    private val mutableUIState: MutableStateFlow<EmailListContract.EmailListState> =
        MutableStateFlow(EmailListContract.EmailListState.Loading)

    private val mutableSharedFlow: MutableSharedFlow<EmailListContract.EmailListEffect> =
        MutableSharedFlow()

    override val state: StateFlow<EmailListContract.EmailListState>
        get() = mutableUIState.asStateFlow()
    override val effect: SharedFlow<EmailListContract.EmailListEffect>
        get() = mutableSharedFlow.asSharedFlow()

    override fun event(event: EmailListContract.EmailListEvent) =
        when (event) {
            is EmailListContract.EmailListEvent.LoadEmailList -> {
                mutableUIState.value = EmailListContract.EmailListState.Loading
                loadEmail()
            }

            is EmailListContract.EmailListEvent.EmailClicked -> {
            }
        }

    private fun loadEmail() {
        viewModelScope.launch {
            getEmailsUseCase().fold(
                {
                    mutableUIState.update { state ->
                        Log.e("Mithilesh", "loadEmail: $it")
                        EmailListContract.EmailListState.Error(
                            it
                        )
                    }
                },
                {
                    mutableUIState.update { state ->
                        EmailListContract.EmailListState.Success(
                            emailList = it
                        )
                    }
                }
            )
        }
    }
}
