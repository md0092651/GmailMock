package com.coroutinelab.presentation.emaillist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.coroutinelab.coreui.component.EmailItem
import com.coroutinelab.presentation.emaillist.mvi.EmailListContract
import com.coroutinelab.presentation.emaillist.mvi.EmailListViewModel

@Composable
fun EmailListScreen(viewModel: EmailListViewModel = hiltViewModel(), onItemClick: () -> Unit) {
    val states = viewModel.state.collectAsState().value
    LaunchedEffect(states) {
        if (states !is EmailListContract.EmailListState.Success) {
            viewModel.event(EmailListContract.EmailListEvent.LoadEmailList)
        }
    }

    when (states) {
        is EmailListContract.EmailListState.Error -> Text(states.error.toString())
        EmailListContract.EmailListState.Loading -> Text("Loading")
        is EmailListContract.EmailListState.Success -> EmailListUi(states, onItemClick)
    }
}

@Composable
fun EmailListUi(states: EmailListContract.EmailListState.Success, onItemClick: () -> Unit) {
    LazyColumn {
        items(states.emailList) {
            EmailItem(
                modifier = Modifier.clickable {
                    onItemClick()
                },
                profileImageUrl = it.profileImage,
                senderName = it.from,
                emailSubject = it.subject,
                emailSnippet = it.snippet,
                isStarred = it.isStarred
            )
        }
    }
}
