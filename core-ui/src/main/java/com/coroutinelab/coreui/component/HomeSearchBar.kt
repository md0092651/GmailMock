package com.coroutinelab.coreui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.coroutinelab.coreui.R
import com.coroutinelab.coreui.theme.Dimensions

@Composable
fun HomeAppBar(modifier: Modifier = Modifier, onMenuClick: () -> Unit) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(Dimensions.dimen_64)
            .background(
                color = MaterialTheme.colorScheme.surfaceContainer,
                shape = RoundedCornerShape(Dimensions.dimen_48)
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { onMenuClick() }) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu"
            )
        }

        Text(
            text = stringResource(R.string.txt_search),
            modifier = Modifier.weight(1f)
        )

        CircularProfileImage(
            modifier = Modifier.padding(horizontal = Dimensions.dimen_16),
            imageSource = "https://i.pravatar.cc/250?img=5"
        )
    }
}

@Preview
@Composable
fun HomeAppBarPreview() {
    HomeAppBar {}
}