package ru.nlct.nationalkeyboard

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.HelpOutline
import androidx.compose.material.icons.filled.RateReview
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SettingsToolBar(title: @Composable () -> Unit, onRating: (() -> Unit)?, onHelp: (() -> Unit)?) {
    TopAppBar(
        title = title,
        navigationIcon = null,
        backgroundColor = MaterialTheme.colors.primaryVariant,
        contentColor = MaterialTheme.colors.onSurface,
        actions = {
            if (onRating != null) {
                IconButton(onClick = { onRating.invoke() }) {
                    Icon(imageVector = Icons.Default.Star, contentDescription = null)
                }
            }

            if (onHelp != null) {
                IconButton(onClick = { onHelp.invoke() }) {
                    Icon(imageVector = Icons.Default.HelpOutline, contentDescription = null)
                }
            }
        }
    )
}

@Preview
@Composable
fun SearchToolbarPreview() {
    MaterialTheme {
        SettingsToolBar(title = { Text(text = "Title") }, onRating = {}, onHelp = {})
    }
}