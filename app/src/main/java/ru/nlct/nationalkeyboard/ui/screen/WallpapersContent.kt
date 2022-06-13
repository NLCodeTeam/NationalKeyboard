package ru.nlct.nationalkeyboard.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.material.contentColorFor
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.asFlow
import coil.compose.AsyncImage
import ru.nlct.nationalkeyboard.R
import ru.nlct.nationalkeyboard.di.theme.NationalKeyboardTheme
import ru.nlct.nationalkeyboard.di.theme.caption
import ru.nlct.nationalkeyboard.ui.MainViewModel
import ru.nlct.nationalkeyboard.ui.bar.AppScaffold
import ru.nlct.nationalkeyboard.domain.model.WallpaperItem

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun WallpapersContent(
    viewModel: MainViewModel
) {
    NationalKeyboardTheme {
        AppScaffold(
            title = { Text(text = stringResource(id = R.string.wallpapers_title)) },
            onRating = {},
            onHelp = {}
        ) {
            val viewState = viewModel.wallpapersState.collectAsState()
            val empty = WallpaperItem()
            var selectedItem by remember { mutableStateOf(empty) }



            Button(
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.primaryVariant,
                    contentColor = MaterialTheme.colors.onSurface),
                onClick = {
                    selectedItem = empty
                    viewModel.updateSelectedWallpaper(null)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 16.dp, end = 16.dp)
                    .wrapContentHeight(CenterVertically)){
                Text(text = stringResource(id = R.string.wallpapers_delete), fontSize = 16.sp)
            }
            LazyColumn(modifier = Modifier.fillMaxSize().selectableGroup()) {

                fun selectWallpaper(wallpaper: WallpaperItem) {
                    selectedItem = wallpaper
                    viewModel.updateSelectedWallpaper(selectedItem)
                }

                itemsIndexed(items = viewState.value) { _: Int, item: WallpaperItem ->

                    Card(
                        onClick = {
                            selectWallpaper(item)
                        },
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier.height(274.dp).padding(16.dp).fillMaxWidth(),

                    )
                    {
                        Column(modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Top)
                        {
                            AsyncImage(
                                model = item.uri,
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f)
                                    .clip(RoundedCornerShape(8.dp)),
                                contentScale = ContentScale.FillWidth
                            )

                            Box(
                                Modifier
                                    .height(50.dp)
                                    .fillMaxWidth()) {
                                RadioButton(modifier = Modifier
                                    .align(Alignment.CenterStart)
                                    .padding(10.dp),

                                    selected =
                                    if (item.id == selectedItem.id)
                                        selectedItem.selected
                                    else
                                        item.selected,

                                    onClick = {
                                        selectWallpaper(item)
                                    })
                                Text(
                                    text = stringResource(id = item.titleId),
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.clickable(
                                        onClick = { selectWallpaper(item) }
                                    )
                                        .padding(start = 16.dp)
                                        .align(Alignment.Center)
                                )

                            }
                        }
                    }
                }
            }
        }

        viewModel.loadWallpapers()
    }
}

