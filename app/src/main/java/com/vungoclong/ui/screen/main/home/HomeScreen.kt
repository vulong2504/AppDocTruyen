package com.vungoclong.ui.screen.main.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vungoclong.ui.screen.main.home.highlight_story.HighlightStory
import com.vungoclong.ui.screen.main.home.new_update_story.NewUpdateStory
import com.vungoclong.ui.screen.main.home.random_story.RandomStory
import com.vungoclong.ui.theme.colorBackground
import com.vungoclong.ui.theme.colorMain
import com.vungoclong.util.State
import com.vungoclong.viewmodel.main.home.HomeScreenViewModel


@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = viewModel()
) {
    Surface(
        color = colorBackground,
        modifier = Modifier.fillMaxSize()
    ) {
        if (viewModel.highLightState.value is State.Loading || viewModel.favoriteState.value is State.Loading || viewModel.newUpdateState.value is State.Loading) {
            Box(Modifier.fillMaxSize()) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center),
                    color = colorMain
                )
            }
        } else {
            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .fillMaxSize()
            ) {
                HighlightStory(viewModel, onItemClick = {
                })
                NewUpdateStory(viewModel, onItemClick = {

                })
                RandomStory(viewModel, onItemClick = {
                })

            }
        }

    }
}


@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}



