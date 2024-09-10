package com.coroutinelab.coreui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Archive
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun DetailsAppBar(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { }) {
            Icon(Icons.Default.ArrowBackIosNew, contentDescription = "Back")
        }
        Spacer(Modifier.weight(1f))
        IconButton(onClick = { }) {
            Icon(Icons.Default.Archive, contentDescription = "Back")
        }
        IconButton(onClick = { }) {
            Icon(Icons.Default.Delete, contentDescription = "Back")
        }
        IconButton(onClick = { }) {
            Icon(Icons.Default.Mail, contentDescription = "Back")
        }
        IconButton(onClick = { }) {
            Icon(Icons.Default.MoreVert, contentDescription = "Back")
        }
    }
}

@Preview
@Composable
fun DetailsAppBarPreview() {
    DetailsAppBar()
}
