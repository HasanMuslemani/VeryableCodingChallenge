package com.veryable.android.presentation.accounts.components

import android.util.Log.d
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import com.veryable.android.R
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.veryable.android.presentation.theme.onSecondaryVariant

@Composable
fun AccountItem(
    drawable: Int,
    name: String,
    description: String,
    transferType: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.secondary)
            .border(.3.dp, Color.Gray)
            .clickable(onClick = onClick)
            .padding(horizontal = 10.dp, vertical = 15.dp),
        verticalAlignment = Alignment.Top
    ) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = stringResource(R.string.content_description_account_icon),
            colorFilter = ColorFilter.tint(MaterialTheme.colors.primary),
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
            ) {
                Text(
                    name,
                    style = MaterialTheme.typography.h3,
                    color = MaterialTheme.colors.onSecondary
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    description,
                    style = MaterialTheme.typography.subtitle2,
                    color = MaterialTheme.colors.onSecondary
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    transferType,
                    style = MaterialTheme.typography.subtitle2,
                    color = MaterialTheme.colors.onSecondaryVariant
                )
            }
            Icon(
                imageVector = Icons.Default.ChevronRight,
                contentDescription = "Right Arrow Icon",
                tint = MaterialTheme.colors.onSecondaryVariant
            )
        }
    }
}