package ru.nlct.nationalkeyboard.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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

                    }
                }
                item {
                    UserInput(text = stringResource(id = R.string.select_lang_keyboard_title), vectorImageId = R.drawable.ic_baseline_language_24) {

                    }
                }
                item {
                    UserInput(text = stringResource(id = R.string.dictionary_keyboard_title), vectorImageId = R.drawable.ic_baseline_checklist_24) {

                    }
                }
                item {
                    UserInput(text = stringResource(id = R.string.wallpapers_keyboard_title), vectorImageId = R.drawable.ic_baseline_wallpaper_24) {

                    }
                }
                item {
                    EditableUserInput(hint = stringResource(id = R.string.test_keyboard_title), vectorImageId = R.drawable.ic_baseline_keyboard_double_arrow_right_24) {

                    }
                }
            }

            //val keyboardStepItems = buildStepItems(R.array.main_content_titles, R.array.main_content_info)

            /*LazyVerticalGrid(
                columns = GridCells.Fixed(6),
                modifier = Modifier.padding(start = 24.dp, top = 0.dp, end = 24.dp, bottom = 12.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),

            ) {
                item {
                    UserInput(text = stringResource(id = R.string.enable_keyboard_title), vectorImageId = R.drawable.ic_baseline_keyboard_24) {

                    }
                }
                item {
                    UserInput(text = stringResource(id = R.string.select_keyboard_title), vectorImageId = R.drawable.ic_baseline_keyboard_24) {

                    }
                }
                item {
                    UserInput(text = stringResource(id = R.string.select_lang_keyboard_title), vectorImageId = R.drawable.ic_baseline_keyboard_24) {

                    }
                }
                item {
                    UserInput(text = stringResource(id = R.string.dictionary_keyboard_title), vectorImageId = R.drawable.ic_baseline_keyboard_24) {

                    }
                }
                item {
                    UserInput(text = stringResource(id = R.string.wallpapers_keyboard_title), vectorImageId = R.drawable.ic_baseline_keyboard_24) {

                    }
                }
                item {
                    UserInput(text = stringResource(id = R.string.test_keyboard_title), vectorImageId = R.drawable.ic_baseline_keyboard_24) {

                    }
                }
            }
            LazyColumn {
                items(keyboardStepItems.size) { item ->
                    MealItem(keyboardStepItems.first { it.id == item }) {
                    }
                }
            }*/
        }
    }
}

@Composable
fun MealItem(
    step: KeyboardStepItem,
    modifier: Modifier = Modifier,
    onDetail: (KeyboardStepItem) -> Unit
) {

    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp, horizontal = 4.dp),
            //.border(2.dp, color = MaterialTheme.colors.primary, shape = RoundedCornerShape(8.dp)),
        elevation = 8.dp,
        shape = RoundedCornerShape(8.dp),
    ) {
        Row(
            modifier = Modifier
                .padding(4.dp)
                .semantics {
                    customActions = listOf(
                        CustomAccessibilityAction(
                            label = "",
                            action = { true }
                        )
                    )
                }
        ) {
            Column(modifier = Modifier.weight(1f)) {
                
                IconButton(onClick = { onDetail.invoke(step) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp, horizontal = 4.dp)
                ) {
                    //Icon(imageVector = Icons.Filled.Keyboard)
                }

                Text(
                    text = step.info,
                    style = MaterialTheme.typography.subtitle1,
                    textAlign = TextAlign.Start,
                    maxLines = 2,
                    color = Color.LightGray,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            vertical = 8.dp,
                            horizontal = 4.dp
                        )
                )
                /*Text(
                    text = step.title,
                    style = MaterialTheme.typography.body1,
                    textAlign = TextAlign.Start,
                    maxLines = 2,
                    color = MaterialTheme.colors.primary,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            vertical = 8.dp,
                            horizontal = 4.dp
                        )
                ) */
            }


        }
    }
}

@Preview
@Composable
fun previewMealItem() {
    MealItem(
        KeyboardStepItem(0, "Включить клавиатуру", "Шаг 1: включите клавиатуру (Кавказская клавиатура)"),
        Modifier.height(16.dp),
    ) {

    }
}

@Composable
fun buildStepItems(
    keysArrayId: Int,
    valuesArrayId: Int
): List<KeyboardStepItem>  {
    val keysArray = stringArrayResource(id = keysArrayId)
    val valuesArray = stringArrayResource(id = valuesArrayId)

    val steps = mutableListOf<KeyboardStepItem>()
    if (keysArray.size == valuesArray.size) {
        var pos = 0
        keysArray.zip(valuesArray).forEach {
            steps.add(KeyboardStepItem(pos, it.first,it.second))
            pos++
        }
    }

    return steps
}
