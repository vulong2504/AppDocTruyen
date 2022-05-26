@file:OptIn(ExperimentalMaterialApi::class)

package com.vungoclong.ui.screen.main.home.random_story

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.vungoclong.model.Book
import com.vungoclong.ui.theme.*
import com.vungoclong.util.Helper
import com.vungoclong.viewmodel.main.home.HomeScreenViewModel

@Composable
fun RandomStory(
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
            text = "Có thể bạn sẽ thích",
            textAlign = TextAlign.Center,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.h3,
            color = colorMain,
        )
        Row(
            modifier = Modifier
                .horizontalScroll(rememberScrollState())
                .fillMaxWidth()
                .height(380.dp)
        ) {
            viewModel.listFavoriteStory.value.forEach {
                RandomStoryItem(it, onItemClick)
            }
        }
    }
}

@Composable
fun RowScope.RandomStoryItem(
    book: Book,
    onItemClick: (Book) -> Unit
) {
    Box(
    ) {
        Card(
            modifier = Modifier
                .padding(LARGE_PADDING + SMALL_PADDING)
                .size(300.dp)
                .align(Alignment.Center),
            onClick = {
                onItemClick(book)
            }
        ) {
            Column(
                modifier = Modifier.padding(
                    top = SMALL_PADDING,
                    end = SMALL_PADDING
                )
            ) {
                Column(
                    modifier = Modifier.height(100.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        modifier = Modifier
                            .padding(
                                start = EXTRA_LARGE_PADDING + LARGE_PADDING,
                            ),
                        text = book.name!!,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.h5,
                        color = Color.Black
                    )
                    Text(
                        modifier = Modifier
                            .padding(
                                start = EXTRA_LARGE_PADDING + LARGE_PADDING,
                            ),
                        text = "Tác giả: ${book.author}",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.h6,
                        color = colorText2
                    )
                    Text(
                        modifier = Modifier
                            .padding(
                                start = EXTRA_LARGE_PADDING + LARGE_PADDING,
                            ),
                        text = "Thể loại: ${Helper.categoryArrayToString(book.category!!)}",
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.h6,
                        color = colorText2
                    )
                }
                Text(
                    modifier = Modifier
                        .padding(
                            start = MEDIUM_PADDING, top = MEDIUM_PADDING, end = MEDIUM_PADDING
                        ),
                    text = book.description!!,
                    maxLines = 5,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.h6,
                    color = colorText2
                )
            }
        }
        Row(
            modifier = Modifier
                .padding(bottom = LARGE_PADDING + SMALL_PADDING)
                .width(300.dp)
                .align(Alignment.BottomCenter)
                .padding(MEDIUM_PADDING),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
//            Row(verticalAlignment = Alignment.CenterVertically) {
//                Text(
//                    text = "7.8", style = MaterialTheme.typography.h5,
//                    color = colorMain
//                )
//                Icon(
//                    modifier = Modifier.padding(bottom = 2.dp).size(15.dp),
//                    imageVector = Icons.Filled.Star,
//                    contentDescription = null,
//                    tint = colorMain
//                )
//            }

            Text(
                text = "${book.chapterNumber} chương",
                style = MaterialTheme.typography.h6,
                color = colorMain
            )
            Button(
                onClick = {
                    onItemClick(book)
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = colorMain)
            ) {
                Text(
                    text = "Đọc Truyện",
                    style = MaterialTheme.typography.h5,
                    color = Color.White
                )
            }

        }
        Image(
            painter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(book.imageUrl)
                    .build()
            ),
            modifier = Modifier
                .padding(SMALL_PADDING)
                .height(130.dp)
                .width(70.dp)
                .shadow(
                    elevation = 5.dp,
                    shape = RoundedCornerShape(4.dp),
                    clip = true
                )
                .align(Alignment.TopStart)
                .clickable {
                    onItemClick(book)
                },
            contentScale = ContentScale.FillBounds,
            contentDescription = null,
        )
    }
}



