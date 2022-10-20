package com.veryable.android.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.compose.rememberNavController
import com.veryable.android.presentation.account_details.AccountDetailsScreen
import com.veryable.android.presentation.accounts.AccountsScreen
import com.veryable.android.presentation.theme.BankTheme

class PayoutsListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BankTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
//                            title = {
//                                Text(
//                                    "DETAILS",
//                                    style = MaterialTheme.typography.h1,
//                                    color = MaterialTheme.colors.onSecondary,
//                                    modifier = Modifier.fillMaxWidth().background(Color.Red)
//                                )
//                            },
//                            navigationIcon = {
//                                IconButton(onClick = { /*TODO*/ }) {
//                                    Icon(
//                                        imageVector = Icons.Default.ArrowBack,
//                                        contentDescription = "Back Button",
//                                        tint = Color.Black
//                                    )
//                                }
//                            },
                            backgroundColor = MaterialTheme.colors.secondary,
                        ) {
                            BoxWithConstraints(
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                IconButton(
                                    onClick = {  },
                                    modifier = Modifier.align(Alignment.CenterStart)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.ArrowBack,
                                        contentDescription = "Back Button",
                                        tint = Color.Black
                                    )
                                }
                                Text(
                                    "DETAILS",
                                    style = MaterialTheme.typography.h1,
                                    color = MaterialTheme.colors.onSecondary,
                                    modifier = Modifier
                                        .align(Alignment.Center)
                                )
                            }
                        }
                    }
                ) {
                    val navController = rememberNavController()
                    Navigation(navController)
                }
            }
        }
    }
}