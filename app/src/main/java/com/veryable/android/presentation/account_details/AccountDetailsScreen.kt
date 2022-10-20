package com.veryable.android.presentation.account_details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.veryable.android.R
import com.veryable.android.data.remote.dto.Account
import com.veryable.android.presentation.theme.onSecondaryVariant

@Composable
fun AccountDetailsScreen(
    navController: NavController
) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.secondaryVariant)
            .padding(25.dp),
    ) {
        val account: Account? = navController.previousBackStackEntry?.savedStateHandle?.get<Account>("account")
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(id = R.drawable.account_icon),
                contentDescription = "Account Type Icon",
                colorFilter = ColorFilter.tint(MaterialTheme.colors.primary),
                modifier = Modifier.size(100.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                account?.accountName ?: "",
                style = MaterialTheme.typography.h2,
                color = MaterialTheme.colors.onSecondary
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                account?.desc ?: "",
                style = MaterialTheme.typography.subtitle1,
                color = MaterialTheme.colors.onSecondaryVariant
            )
        }
        Button(
            onClick = {
                navController.popBackStack()
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.primary
            ),
            elevation = ButtonDefaults.elevation(
                defaultElevation = 5.dp
            ),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                "DONE",
                style = MaterialTheme.typography.button,
                color = MaterialTheme.colors.onPrimary,
                modifier = Modifier
                    .padding(vertical = 10.dp)
            )
        }
    }
}