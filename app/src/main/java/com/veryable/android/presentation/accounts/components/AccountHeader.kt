package com.veryable.android.presentation.accounts.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AccountHeader(
    title: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.secondaryVariant)
    ) {
        Text(
            title,
            style = MaterialTheme.typography.h2,
            color = MaterialTheme.colors.onSecondary,
            modifier = Modifier.padding(10.dp)
        )
    }
}