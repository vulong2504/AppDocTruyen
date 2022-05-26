@file:OptIn(ExperimentalMaterialApi::class)

package com.vungoclong.ui.screen.main.history

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.vungoclong.R
import com.vungoclong.ui.theme.*

@Composable
fun HistoryScreen(

) {
    Surface(
        color = colorBackground,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = MEDIUM_PADDING)
                .verticalScroll(rememberScrollState())
                .padding(top = MEDIUM_PADDING)
            ,
        ) {
            LoginSuggestion {

            }
            CurrentReading {}
            DownloadedStory()
        }

    }
}

@Composable
fun ColumnScope.CurrentReading(
    onClick: () -> Unit
) {
    Text(
        modifier = Modifier.padding(start = 2.dp, top = MEDIUM_PADDING),
        text = "Truyện đang đọc",
        textAlign = TextAlign.Center,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis,
        style = MaterialTheme.typography.h3,
        color = colorMain
    )
    Spacer(modifier = Modifier.height(SMALL_PADDING))
    Card(
        shape = RoundedCornerShape(
            topEnd = 50.dp,
            topStart = 4.dp,
            bottomEnd = 4.dp,
            bottomStart = 4.dp
        ),
        onClick = {
            onClick()
        },
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://i.imgur.com/hufxu1G.jpg")
                        .build()
                ),
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.FillBounds,
                contentDescription = null
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(colorBlur1)
                    .padding(SMALL_PADDING),
            ) {
                Text(
                    text = "Đọc tiếp chương 999",
                    style = MaterialTheme.typography.h6,
                    color = Color.White,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = "Tôi nói gì khi nói về chạy bộ",
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.h5,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold
                )
                Box(modifier = Modifier.fillMaxSize()) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.align(
                            Alignment.BottomStart
                        )
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_stopwatch),
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.padding(bottom = 3.dp)
                        )
                        Spacer(modifier = Modifier.width(EXTRA_SMALL_PADDING))
                        Text(
                            text = "1 ngày trước",
                            style = MaterialTheme.typography.h5,
                            color = Color.White,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    OutlinedButton(
                        onClick = {

                        },
                        modifier = Modifier
                            .size(40.dp)
                            .align(Alignment.BottomEnd),
                        shape = CircleShape,
                        contentPadding = PaddingValues(0.dp),  //avoid the little icon
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White)
                    ) {
                        Icon(
                            Icons.Filled.PlayArrow,
                            contentDescription = null,
                            tint = colorMain,
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ColumnScope.DownloadedStory() {
    Text(
        modifier = Modifier.padding(start = 2.dp, top = MEDIUM_PADDING),
        text = "Truyện đã tải",
        textAlign = TextAlign.Center,
        overflow = TextOverflow.Ellipsis,
        style = MaterialTheme.typography.h3,
        color = colorMain
    )
    Spacer(modifier = Modifier.height(SMALL_PADDING))

    DownloadedStoryItem()
    Spacer(modifier = Modifier.height(SMALL_PADDING))
    DownloadedStoryItem()
    Spacer(modifier = Modifier.height(SMALL_PADDING))
    DownloadedStoryItem()
    Spacer(modifier = Modifier.height(SMALL_PADDING))
    DownloadedStoryItem()
    Spacer(modifier = Modifier.height(SMALL_PADDING))


}

@Composable
fun DownloadedStoryItem() {
    Card(
        modifier = Modifier
            .height(80.dp)
            .fillMaxWidth(),
        onClick = {
        }
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = rememberAsyncImagePainter(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("https://i.imgur.com/hufxu1G.jpg")
                        .build()
                ),
                modifier = Modifier
                    .fillMaxHeight()
                    .width(70.dp),
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
                    text = "Rừng na uy",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.h5,
                    color = Color.Black

                )
                Text(
                    text = "Tác giả: Haruki murakami",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.h6,
                    color = colorText2
                )
            }
        }
    }
}

@Composable
fun ColumnScope.LoginSuggestion(
    onClick: () -> Unit
) {
    Card(
        onClick = {
            onClick()
        },
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            colorMain,
                            colorGradientMain
                        )
                    )
                )
                .padding(SMALL_PADDING),
        ) {
            Text(
                text = "Gợi ý:",
                style = MaterialTheme.typography.h6,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(SMALL_PADDING))
            Text(
                text = "Hãy đăng nhập để đồng bộ tiến trình đọc trên các thiết bị khác của bạn!",
                style = MaterialTheme.typography.h5,
                color = Color.White
            )
            Box(modifier = Modifier.fillMaxSize()) {
                Button(
                    onClick = {

                    },
                    modifier = Modifier.align(Alignment.BottomEnd),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
                ) {
                    Text(
                        text = "Đăng nhập",
                        style = MaterialTheme.typography.h5,
                        color = Color.Black
                    )
                }
            }
        }
    }
}