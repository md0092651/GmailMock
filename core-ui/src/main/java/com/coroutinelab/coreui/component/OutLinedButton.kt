package com.coroutinelab.coreui.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun OutLinedButton(modifier: Modifier, buttonText: String, @DrawableRes buttonIcon: Int, onclick: () -> Unit) {
    OutlinedButton(
        modifier = modifier,
        onClick = onclick,
        shape = RoundedCornerShape(30),
        border = BorderStroke(1.dp, Color.DarkGray)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = buttonIcon),
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = buttonText)
        }
    }
}

@Preview
@Composable
fun OutLinedButtonPreview() {
    OutLinedButton(
        modifier = Modifier,
        buttonText = "Button",
        buttonIcon = android.R.drawable.ic_menu_add
    ) {}
}
