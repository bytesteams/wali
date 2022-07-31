package org.jetbinary.wali.ui

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.jetbinary.wali.model.DisplayText
import org.jetbinary.wali.theme.WaliTheme
import org.jetbinary.wali.ui.element.PlayBar
import org.jetbinary.wali.ui.element.ToolBar

@Composable
fun HomePage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(WaliTheme.colors.background)
    ) {
        ToolBar(
            title = DisplayText("Wali")
        )

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {

            Box(
                modifier = Modifier
                    .size(260.dp)
                    .border(width = 8.dp, color = WaliTheme.colors.secondary, shape = CircleShape)
                    .clip(CircleShape)
                    .background(WaliTheme.colors.primary)
            ) {

            }
        }

        PlayBar()
    }
}


// Preview
////////////////////////////////////////////////////////////////
@Preview(name = "light mode")
@Preview(name = "dark mode", uiMode = UI_MODE_NIGHT_YES)
@Composable
fun Preview() {
    WaliTheme {
        HomePage()
    }
}
