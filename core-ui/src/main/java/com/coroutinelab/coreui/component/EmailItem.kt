package com.coroutinelab.coreui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension

@Composable
fun EmailItem(
    modifier: Modifier,
    profileImageUrl: String?,
    senderName: String,
    emailSubject: String,
    emailSnippet: String,
    isStarred: Boolean
) {
    ConstraintLayout(
        modifier =
        modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        val (avatar, from, subject, snippet, time, star, buttons) = createRefs()

        profileImageUrl?.let {
            CircularProfileImage(
                modifier =
                Modifier.constrainAs(avatar) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                },
                imageSource = profileImageUrl,
                size = 32.dp
            )
        } ?: Box(
            modifier = Modifier
                .size(32.dp)
                .clip(CircleShape)
                .background(color = Color.Green),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "HV")
        }

        Text(
            text = senderName,
            modifier =
            Modifier.constrainAs(from) {
                top.linkTo(avatar.top)
                start.linkTo(avatar.end, margin = 16.dp)
                end.linkTo(time.start, margin = 8.dp)
                width = Dimension.fillToConstraints
            },
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            maxLines = 1
        )

        Text(
            text = emailSubject,
            modifier =
            Modifier.constrainAs(subject) {
                top.linkTo(from.bottom)
                start.linkTo(from.start)
                end.linkTo(star.start, margin = 8.dp)
                width = Dimension.fillToConstraints
            },
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            maxLines = 1
        )

        Text(
            text = emailSnippet,
            modifier =
            Modifier.constrainAs(snippet) {
                top.linkTo(subject.bottom, margin = 4.dp)
                start.linkTo(from.start)
            },
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp
        )

        Text(
            text = "June 19",
            modifier =
            Modifier.constrainAs(time) {
                end.linkTo(parent.end)
                top.linkTo(from.top)
            },
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp
        )

        Icon(

            Icons.Default.Star,
            contentDescription = null,
            tint = if (isStarred) Color(0xFFFFD700) else Color(0x706B6B6E),
            modifier =
            Modifier
                .size(24.dp)
                .constrainAs(star) {
                    end.linkTo(parent.end)
                    top.linkTo(time.bottom, margin = 4.dp)
                }
        )
    }
}
/*
@Preview
@Composable
fun EmailItemPreview() {
    EmailItem(
        modifier = Modifier,
        onEmailClick = {},
        data = it
    )
}*/
