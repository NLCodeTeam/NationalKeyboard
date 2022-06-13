package ru.nlct.nationalkeyboard.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.nlct.nationalkeyboard.R
import ru.nlct.nationalkeyboard.di.theme.NationalKeyboardTheme
import ru.nlct.nationalkeyboard.ui.MainViewModel
import ru.nlct.nationalkeyboard.ui.bar.AppScaffold

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainContent(
    viewModel: MainViewModel
) {
    NationalKeyboardTheme {
        AppScaffold(
            title = { Text(text = stringResource(id = R.string.app_name)) },
            onRating = {},
            onHelp = {}
        ) {


            LazyColumn(
                modifier = Modifier.padding(start = 24.dp, top = 0.dp, end = 24.dp, bottom = 12.dp)
                    .fillMaxHeight()
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
            ) {
                item {
                    UserInput(text = stringResource(id = R.string.enable_keyboard_title), vectorImageId = R.drawable.ic_baseline_keyboard_24) {
                        viewModel.enableKeyboard()
                    }
                }
                item {
                    UserInput(text = stringResource(id = R.string.select_keyboard_title), vectorImageId = R.drawable.ic_baseline_spellcheck_24) {
                        viewModel.selectKeyboard()
                    }
                }
                item {
                    UserInput(text = stringResource(id = R.string.select_lang_keyboard_title), vectorImageId = R.drawable.ic_baseline_language_24) {
                        viewModel.openLanguagesScreen()
                    }
                }
                item {
                    UserInput(text = stringResource(id = R.string.dictionary_keyboard_title), vectorImageId = R.drawable.ic_baseline_checklist_24) {
                        viewModel.openDictsScreen()
                    }
                }
                item {
                    UserInput(text = stringResource(id = R.string.wallpapers_keyboard_title), vectorImageId = R.drawable.ic_baseline_wallpaper_24) {
                        viewModel.openWallpapersScreen()
                    }
                }
                item {
                    EditableUserInput(hint = stringResource(id = R.string.test_keyboard_title), vectorImageId = R.drawable.ic_baseline_keyboard_double_arrow_right_24) {

                    }

                }
            }
        }
    }
}
