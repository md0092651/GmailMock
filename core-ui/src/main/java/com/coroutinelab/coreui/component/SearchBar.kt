package com.coroutinelab.coreui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SearchBar(modifier: Modifier, profileImageSource: String, onSearch: (String) -> Unit, onMenuClick: () -> Unit) {
    Row(
        modifier = modifier.background(color = Color(0xFFF7F8FC), shape = RoundedCornerShape(100)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            modifier =
            Modifier.padding(
                start = 12.dp
            ),
            onClick = onMenuClick
        ) {
            Icon(Icons.Default.Menu, contentDescription = "Menu")
        }
        Text(
            modifier = Modifier.weight(1f),
            text = "Search in mail"
        )
        CircularProfileImage(
            modifier =
            Modifier
                .padding(
                    end = 12.dp,
                    top = 8.dp,
                    bottom = 8.dp
                )
                .size(28.dp),
            imageSource = profileImageSource
        )
    }
}

@Preview
@Composable
fun SearchBarPreview() {
    SearchBar(
        modifier = Modifier.padding(16.dp),
        profileImageSource = "https://i.pravatar.cc/250?img=5",
        onSearch = {},
        onMenuClick = {}
    )
}
