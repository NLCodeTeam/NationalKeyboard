package ru.nlct.nationalkeyboard.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.nlct.nationalkeyboard.R
import ru.nlct.nationalkeyboard.di.theme.NationalKeyboardTheme
import ru.nlct.nationalkeyboard.ui.model.ScreenNavigation

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val appName = stringResource(id = R.string.app_name)
            val languages = stringResource(id = R.string.select_lang_keyboard_title)
            val background = stringResource(id = R.string.wallpapers_keyboard_title)
            val dict = stringResource(id = R.string.dictionary_keyboard_title)

            LaunchedEffect(key1 = Unit) {
                viewModel.changeScreenState.collect {
                    when(it) {
                        ScreenNavigation.EnableKeyboard -> openKeyboardSettings()
                        ScreenNavigation.SelectKeyboard -> selectKeyboard()
                        else -> navController.navigate(getString(it.resId))
                    }
                }
            }

            NationalKeyboardTheme {
                NavHost(
                    navController = navController, 
                    startDestination = appName,
                ) {
                    composable(appName) {
                        MainContent(viewModel = viewModel)
                    }
                    composable(languages) {
                        LanguagesContent(viewModel = viewModel)
                    }
                    composable(background) {
                        KeyboardBackgroundContent(viewModel = viewModel)
                    }
                    composable(dict) {
                        DictionariesContent(viewModel = viewModel)
                    }
                }
            }
        }

        viewModel.loadLanguages()
    }

    private fun openKeyboardSettings() {
        startForResult.launch(Intent(android.provider.Settings.ACTION_INPUT_METHOD_SETTINGS))
    }

    private fun selectKeyboard() {
        (getSystemService(INPUT_METHOD_SERVICE) as? InputMethodManager)?.showInputMethodPicker()
    }

    private val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val intent = result.data
            // Handle the Intent
            //do stuff here
        }
    }
}