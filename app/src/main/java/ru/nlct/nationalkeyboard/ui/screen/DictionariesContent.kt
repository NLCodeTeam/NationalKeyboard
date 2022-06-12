package ru.nlct.nationalkeyboard.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.CustomAccessibilityAction
import androidx.compose.ui.semantics.customActions
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.nlct.nationalkeyboard.R
import ru.nlct.nationalkeyboard.di.theme.NationalKeyboardTheme
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




