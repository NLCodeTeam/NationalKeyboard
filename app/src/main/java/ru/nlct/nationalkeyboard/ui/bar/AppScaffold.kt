package ru.nlct.nationalkeyboard.ui.bar

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AppScaffold(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    title: @Composable (() -> Unit)? = null,
    onRating: (() -> Unit)? = null,
    onHelp: (() -> Unit)? = null,
    content: @Composable (ColumnScope.() -> Unit),
) {
    Scaffold(
        scaffoldState = scaffoldState,
        backgroundColor = MaterialTheme.colors.primary,
        topBar = {
            if (title != null) {
                SettingsToolBar(
                    title = title,
                    onRating = onRating,
                    onHelp = onHelp
                )
            }
        },

    ) { paddings ->
        Column(
            modifier = Modifier.scrollable(
                state = rememberScrollState(),
                orientation = Orientation.Vertical,

            ).padding(paddings),
            content = content
        )
    }
}


