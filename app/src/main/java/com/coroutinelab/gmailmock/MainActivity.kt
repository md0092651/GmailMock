package com.coroutinelab.gmailmock

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
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
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Box(Modifier.safeDrawingPadding()) {
                GmailMockTheme {
                    val navController = rememberNavController()
                    val drawerState = rememberDrawerState(DrawerValue.Closed)

                    Scaffold(
                        topBar = {
                            val navBackStackEntry by navController.currentBackStackEntryAsState()
                            val currentDestination = navBackStackEntry?.destination?.route
                            when (currentDestination) {
                                EmailList::class.qualifiedName -> HomeAppBar()
                                EmailDetails::class.qualifiedName -> DetailsAppBar()
                                else -> HomeAppBar()
                            }
                        }
                    ) { innerPadding ->
                        NavHost(
                            navController = navController,
                            startDestination = EmailList,
                            modifier = Modifier.padding(innerPadding)
                        ) {
                            composable<EmailList> {
                                EmailListScreen {
                                    navController.navigate(EmailDetails)
                                }
                            }
                            composable<EmailDetails> {
                                EmailDetailsScreen()
                            }
                        }
                    }
                }
            }
        }
    }
}
