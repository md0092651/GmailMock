package com.coroutinelab.gmailmock

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.coroutinelab.gmailmock.ui.theme.GmailMockTheme
import com.coroutinelab.presentation.emaillist.EmailListScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.serialization.Serializable

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GmailMockTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = EmailList
                ) {
                    composable<EmailList> {
                        EmailListScreen {
                            navController.navigate(EmailDetails)
                        }
                    }
                }
            }
        }
    }
}

@Serializable
object EmailList

@Serializable
object EmailDetails
