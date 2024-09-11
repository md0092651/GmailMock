package com.coroutinelab.gmailmock

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.coroutinelab.coreui.component.DetailsAppBar
import com.coroutinelab.coreui.component.HomeAppBar
import com.coroutinelab.gmailmock.navigation.EmailDetails
import com.coroutinelab.gmailmock.navigation.EmailList
import com.coroutinelab.gmailmock.ui.theme.GmailMockTheme
import com.coroutinelab.presentation.emaildetails.EmailDetailsScreen
import com.coroutinelab.presentation.emaillist.EmailListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            Box(Modifier.safeDrawingPadding()) {
                GmailMockTheme {
                    val navController = rememberNavController()
                    val drawerState = rememberDrawerState(DrawerValue.Closed)
                    var topAppBarState by remember { mutableStateOf(TopAppBarState.HOME) }
                    Scaffold(
                        topBar = {
                            when (topAppBarState) {
                                TopAppBarState.HOME -> HomeAppBar()
                                TopAppBarState.DETAILS -> DetailsAppBar()
                            }
                        }
                    ) { innerPadding ->
                        NavHost(
                            navController = navController,
                            startDestination = EmailList,
                            modifier = Modifier.padding(innerPadding)
                        ) {
                            composable<EmailList> {
                                topAppBarState = TopAppBarState.HOME
                                EmailListScreen { from, profileImage, subject, isPromotional, isStarred ->
                                    navController.navigate(
                                        EmailDetails(
                                            from = from,
                                            profileImage = profileImage,
                                            subject = subject,
                                            isPromotional = isPromotional,
                                            isStarred = isStarred
                                        )
                                    )
                                }
                            }
                            composable<EmailDetails> {
                                topAppBarState = TopAppBarState.DETAILS
                                val args = it.toRoute<EmailDetails>()
                                EmailDetailsScreen(
                                    from = args.from,
                                    profileImage = args.profileImage,
                                    subject = args.subject,
                                    isPromotional = args.isPromotional
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

enum class TopAppBarState {
    HOME,
    DETAILS
}
