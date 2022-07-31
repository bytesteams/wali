package org.jetbinary.wali.ui.element

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.jetbinary.wali.resource.R
import org.jetbinary.wali.theme.PADDING_LARGE
import org.jetbinary.wali.theme.WaliTheme

@Composable
fun PlayBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(vertical = PADDING_LARGE),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.weight(1f))

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(64.dp)
                .clickable {
                    // play previous one song
                }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_media_play_previous),
                contentDescription = "previous",
                tint = WaliTheme.colors.primary,
                modifier = Modifier
                    .size(32.dp)
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Icon(
            painter = painterResource(id = R.drawable.ic_media_play),
            contentDescription = "previous",
            tint = WaliTheme.colors.primary,
            modifier = Modifier
                .size(64.dp)
                .clickable {
                    // play or pause
                }
        )

        Spacer(modifier = Modifier.weight(1f))

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(64.dp)
                .clickable {
                    // play next one song
                }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_media_play_next),
                contentDescription = "previous",
                tint = WaliTheme.colors.primary,
                modifier = Modifier.size(32.dp)
            )
        }

        Spacer(modifier = Modifier.weight(1f))
    }
}

// Preview
////////////////////////////////////////////////////////////////
@Preview(name = "Play bar")
@Composable
fun PreviewPlayBar() {
    WaliTheme {
        PlayBar()
    }
}
