@file:OptIn(ExperimentalMaterialApi::class)

package com.vungoclong.ui.screen.main.home.highlight_story

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.vungoclong.model.Book
import com.vungoclong.ui.theme.MEDIUM_PADDING
import com.vungoclong.ui.theme.SMALL_PADDING
import com.vungoclong.ui.theme.colorMain
import com.vungoclong.viewmodel.main.home.HomeScreenViewModel

@Composable
fun HighlightStory(
    viewModel: HomeScreenViewModel,
    onItemClick: (Book) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = MEDIUM_PADDING),
    ) {
        Text(
            modifier = Modifier.padding(start = 2.dp, top = MEDIUM_PADDING),
            text = "Truyện nổi bật",
            textAlign = TextAlign.Center,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.h3,
            color = colorMain
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(
                SMALL_PADDING,
                Alignment.CenterHorizontally
            ),
        ) {
            for (i in 0..2) {
                HighlightStoryItem(viewModel.listHighLightStory.value[i],onItemClick)
            }
        }
        Spacer(modifier = Modifier.height(SMALL_PADDING))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(
                SMALL_PADDING,
                Alignment.CenterHorizontally
            ),
        ) {
            for (i in 3..5) {
                HighlightStoryItem(viewModel.listHighLightStory.value[i],onItemClick)
            }
        }
    }


}

@Composable
fun RowScope.HighlightStoryItem(
    book: Book,
    onItemClick: (Book) -> Unit
) {
    Card(
        modifier = Modifier
            .height(170.dp)
            .weight(1f),
        onClick = {
            onItemClick(book)
        }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Image(
                painter = rememberAsyncImagePainter(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(book.imageUrl)
                        .build()
                ),
                modifier = Modifier
                    .height(130.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.FillBounds,
                contentDescription = null
            )
            Box(
                modifier = Modifier
                    .size(width = 115.dp, height = 40.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    modifier = Modifier
                        .padding(2.dp),
                    text = book.name!!,
                    textAlign = TextAlign.Center,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.h5,
                    color = Color.Black
                )
            }
        }
    }
}

@Preview
@Composable
fun HLSPI() {
//    HighlightStoryItem()
}

@Preview
@Composable
fun HLSP() {
//    HighlightStory(viewModel)
}