package com.coroutinelab.coreui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Shortcut
import androidx.compose.material.icons.outlined.Mood
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun EmailDetailsSenderInfo(modifier: Modifier = Modifier, canReply: Boolean = true) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        CircularProfileImage(
            modifier = Modifier,
            imageSource = "https://i.pravatar.cc/250?img=5",
            size = 32.dp
        )

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(10.dp)
        ) {
            Row(
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    modifier = Modifier.weight(4f),
                    text = "Some name which is single line and can ",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    modifier = Modifier.weight(1f),
                    text = "7 days ago",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    maxLines = 1
                )
            }
            Text(
                text = "to me ",
                fontSize = 11.sp,
                fontWeight = FontWeight.Normal,
                maxLines = 1
            )
        }

        if (canReply) {
            IconButton(
                onClick = {},
                modifier = Modifier
                    .padding(4.dp)
                    .size(30.dp)
            ) {
                Icon(
                    imageVector = Icons.Outlined.Mood,
                    contentDescription = null,
                    modifier =
                    Modifier
                        .size(24.dp)
                )
            }
            IconButton(
                onClick = {},
                modifier = Modifier
                    .padding(4.dp)
                    .size(30.dp)
                    .scale(scaleX = -1f, scaleY = 1f)
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Outlined.Shortcut,
                    contentDescription = null,
                    modifier =
                    Modifier
                        .size(24.dp)
                )
            }
        } else {
            TextButton(
                onClick = { }
            ) {
                Text("Unsubscribe")
            }
        }
        IconButton(
            onClick = {},
            modifier = Modifier.size(30.dp)
        ) {
            Icon(
                imageVector = Icons.Outlined.MoreVert,
                contentDescription = null,
                modifier =
                Modifier
                    .size(24.dp)
            )
        }
    }
}
