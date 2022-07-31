package org.jetbinary.wali.ui.element

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import org.jetbinary.wali.resource.R
import org.jetbinary.wali.model.DisplayText
import org.jetbinary.wali.theme.*

@Composable
fun ToolBar(
    title: DisplayText,
    rightButton: ActionButton? = null,
    @DrawableRes leftButtonIconId: Int = R.drawable.ic_arrow_back,
    leftButtonListener: (() -> Unit)? = null,
    requireDivider: Boolean = true
) {
    Column {
        Row(
            Modifier
                .fillMaxWidth()
                .height(TITLE_BAR_HEIGHT)
                .background(WaliTheme.colors.background),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // left button
            leftButtonListener?.let {
                ActionButtonItem(
                    data = ActionButton(
                        iconId = leftButtonIconId,
                        listener = it
                    )
                )
            } ?: run {
                Spacer(modifier = Modifier.size(ACTION_BUTTON_SIZE))
            }
            // title
            Text(
                text = title.text,
                fontSize = FRONT_TITLE,
                color = WaliTheme.colors.primary,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center
            )
            // right button
            rightButton?.let {
                ActionButtonItem(data = it)
            } ?: run {
                Spacer(modifier = Modifier.size(ACTION_BUTTON_SIZE))
            }
        }

        if (requireDivider) {
            Divider()
        }
    }
}

@Composable
fun ActionButtonItem(data: ActionButton) {
    Box(
        Modifier
            .size(width = ACTION_BUTTON_SIZE, height = ACTION_BUTTON_SIZE)
            .clickable {
                data.listener()
            },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = data.iconId),
            contentDescription = data.accessibility,
            tint = WaliTheme.colors.primary,
            modifier = Modifier.size(ICON_SIZE)
        )
    }
}


// Data class
////////////////////////////////////////////////////////////////
data class ActionButton(
    @DrawableRes val iconId: Int,
    val accessibility: String = "",
    val listener: () -> Unit,
)


// Preview
////////////////////////////////////////////////////////////////
@Preview(name = "Toolbar light mode")
@Preview(name = "Toolbar dark mode", uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun PreviewToolBar() {
    WaliTheme {
        ToolBar(
            title = DisplayText("Wali"),
            rightButton = ActionButton(iconId = R.drawable.ic_more_horizontal) {

            },
            leftButtonListener = {

            }
        )
    }
}

@Preview(name = "Action button light mode")
@Preview(name = "Action button dark mode", uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun PreviewActionButtonItem() {
    WaliTheme {
        ActionButtonItem(data = ActionButton(iconId = R.drawable.ic_arrow_back) {
        })
    }
}