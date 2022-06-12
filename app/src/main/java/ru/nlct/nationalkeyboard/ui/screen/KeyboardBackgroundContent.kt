package ru.nlct.nationalkeyboard.ui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import ru.nlct.nationalkeyboard.R
import ru.nlct.nationalkeyboard.di.theme.NationalKeyboardTheme
import ru.nlct.nationalkeyboard.ui.bar.AppScaffold

@Composable
fun KeyboardBackgroundContent(
    viewModel: MainViewModel
) {
    NationalKeyboardTheme {
        AppScaffold(
            title = { Text(text = stringResource(id = R.string.wallpapers_title)) },
            onRating = {},
            onHelp = {}
        ) {

        }
    }
}