@file:OptIn(ExperimentalMaterialApi::class)

package com.vungoclong.ui.screen.main.home.new_update_story

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
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.vungoclong.model.Book
import com.vungoclong.ui.theme.MEDIUM_PADDING
import com.vungoclong.ui.theme.SMALL_PADDING
import com.vungoclong.ui.theme.colorMain
import com.vungoclong.ui.theme.colorText2
import com.vungoclong.viewmodel.main.home.HomeScreenViewModel

@Composable
fun NewUpdateStory(
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
            text = "Truyện mới cập nhật",
            textAlign = TextAlign.Center,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.h3,
            color = colorMain,
        )
        NewUpdateStoryItem(viewModel.listNewUpdateStory.value[0], onItemClick)
        Spacer(modifier = Modifier.height(SMALL_PADDING))
        NewUpdateStoryItem(viewModel.listNewUpdateStory.value[1], onItemClick)
        Spacer(modifier = Modifier.height(SMALL_PADDING))
        NewUpdateStoryItem(viewModel.listNewUpdateStory.value[2], onItemClick)
        Spacer(modifier = Modifier.height(SMALL_PADDING))
        NewUpdateStoryItem(viewModel.listNewUpdateStory.value[3], onItemClick)
    }
}

@Composable
fun NewUpdateStoryItem(
    book: Book,
    onItemClick: (Book) -> Unit
) {
    Card(
        modifier = Modifier
            .height(80.dp)
            .fillMaxWidth(),
        onClick = {
            onItemClick(book)
        }
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = rememberAsyncImagePainter(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(book.imageUrl)
                        .build()
                ),
                modifier = Modifier
                    .fillMaxHeight()
                    .width(60.dp),
                contentScale = ContentScale.FillBounds,
                contentDescription = null
            )
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(horizontal = SMALL_PADDING),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = book.name!!,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.h5,
                    color = Color.Black

                )
                Text(
                    text = "Chương ${book.chapterNumber}",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.h6,
                    color = colorText2
                )
            }
//            Text(
//                modifier = Modifier.padding(end = SMALL_PADDING),
//                text = "20/12",
//                maxLines = 1,
//                overflow = TextOverflow.Ellipsis,
//                style = MaterialTheme.typography.h6,
//                color = colorText2
//            )
        }
    }
}
