package ru.nlct.nationalkeyboard.ui.screen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.nlct.nationalkeyboard.R
import ru.nlct.nationalkeyboard.di.theme.NationalKeyboardTheme
import ru.nlct.nationalkeyboard.ui.MainViewModel
import ru.nlct.nationalkeyboard.ui.bar.AppScaffold

@Composable
fun DictionariesContent(
    viewModel: MainViewModel
) {
    NationalKeyboardTheme {
        AppScaffold(
            title = { Text(text = stringResource(id = R.string.dictionaries_title)) },
            onRating = {},
            onHelp = {}
        ) {
            val viewState = viewModel.dictsState.collectAsState()
            LazyColumn(Modifier.padding(horizontal = 16.dp))
            {
                items(viewState.value) { dict ->
                    Row {
                        Switch(
                            modifier = Modifier.align(CenterVertically),
                            checked = dict.enabled,
                            onCheckedChange = {
                                //if (dict.enabled != it)
                                    //viewModel.changeChooseLanguage(language, it)
                            }
                        )

                        Text(
                            text = dict.title,
                            modifier = Modifier.padding(horizontal = 4.dp).align(CenterVertically)
                        )
                    }

                }
            }

        }
    }
}




