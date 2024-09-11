package com.coroutinelab.presentation.emaildetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.coroutinelab.coreui.component.EmailDetailsBottomSection
import com.coroutinelab.coreui.component.EmailDetailsSenderInfo
import com.coroutinelab.coreui.component.EmailDetailsSubject
import com.coroutinelab.coreui.component.LinearFullScreenProgress
import com.coroutinelab.domain.model.emaildetails.EmailDetailsModel
import com.coroutinelab.presentation.emaildetails.mvi.EmailDetailsContract
import com.coroutinelab.presentation.emaildetails.mvi.EmailDetailsViewModel
import com.mohamedrejeb.richeditor.model.rememberRichTextState
import com.mohamedrejeb.richeditor.ui.material3.RichTextEditor

@Composable
fun EmailDetailsScreen(
    viewModel: EmailDetailsViewModel = hiltViewModel(),
    from: String,
    profileImage: String?,
    subject: String,
    isPromotional: Boolean
) {
    val states = viewModel.state.collectAsState().value
    LaunchedEffect(states) {
        if (states.isLoading) {
            viewModel.event(EmailDetailsContract.EmailDetailsEvent.LoadEmailDetails)
        }
    }
    if (states.isLoading) {
        LinearFullScreenProgress()
    }
    states.details?.let {
        EmailDetailsUi(from, profileImage, subject, isPromotional, it)
    }
}

@Composable
fun EmailDetailsUi(
    from: String,
    profileImage: String?,
    subject: String,
    isPromotional: Boolean,
    emailDetailsModel: EmailDetailsModel
) {
    Column(modifier = Modifier.padding(16.dp)) {
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    EmailDetailsSubject(
                        subject,
                        modifier = Modifier.weight(1f)
                    )

                    Icon(
                        imageVector = Icons.Outlined.Star,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                }

                Spacer(Modifier.height(16.dp))

                EmailDetailsSenderInfo(profileImage = profileImage, isPromotional = isPromotional, from = from)

                Spacer(Modifier.height(16.dp))
                val state = rememberRichTextState()
                RichTextEditor(
                    state.setHtml(emailDetailsModel.htmlBody ?: emailDetailsModel.plainBody),
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                )
            }
        }
        EmailDetailsBottomSection()
    }
}
