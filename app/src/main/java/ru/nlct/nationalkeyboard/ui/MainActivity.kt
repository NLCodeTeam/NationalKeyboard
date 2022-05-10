package ru.nlct.nationalkeyboard.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.nlct.nationalkeyboard.R
import ru.nlct.nationalkeyboard.di.theme.NationalKeyboardTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val appName = stringResource(id = R.string.app_name)
            val languages = stringResource(id = R.string.languages_title)
            val background = stringResource(id = R.string.wallpapers_title)

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
                }
            }
        }


        lifecycleScope.launch {
            viewModel.keyboardEnabledState.collect { state -> openKeyboardSettings(state) }
        }
    }

    private fun openKeyboardSettings(state: Boolean) {
        if (state) {
            startForResult.launch(Intent(android.provider.Settings.ACTION_INPUT_METHOD_SETTINGS))
        }
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