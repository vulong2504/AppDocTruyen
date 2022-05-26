package com.vungoclong.ui.screen.main.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.vungoclong.ui.theme.MEDIUM_PADDING
import com.vungoclong.ui.theme.colorBackground
import com.vungoclong.ui.theme.colorMain

@Composable
fun ProfileScreen() {
    Surface(
        color = colorBackground,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(colorMain)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data("https://i.imgur.com/hufxu1G.jpg")
                            .build()
                    ),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(120.dp)
                        .clip(CircleShape)
                        .border(
                            2.dp,
                            androidx.compose.ui.graphics.Color.Gray,
                            CircleShape
                        )   // add a border (optional)
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                ProfileScreenItem1()
                ProfileScreenItem2()
                ProfileScreenItem3()
            }
        }

    }
}

@Composable
fun ColumnScope.ProfileScreenItem1() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(63.dp)
            .clickable {  },

    ) {
        Text(
            modifier = Modifier
                .padding(start = MEDIUM_PADDING)
                .align(Alignment.CenterStart),
            text = "Tài khoản",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h3,
            color = Color.Black
        )

        Text(
            modifier = Modifier
                .padding(end = MEDIUM_PADDING)
                .align(Alignment.CenterEnd),
            text = "longvn37201@gmail.com",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h5,
            color = Color.Black,
            fontWeight = FontWeight.Light
        )

        Divider(modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.BottomCenter))

    }
}
@Composable
fun ColumnScope.ProfileScreenItem2() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(63.dp)
            .clickable {  },

    ) {
        Text(
            modifier = Modifier
                .padding(start = MEDIUM_PADDING)
                .align(Alignment.CenterStart),
            text = "Giới thiệu",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h3,
            color = Color.Black
        )

        Divider(modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.BottomCenter))

    }
}
@Composable
fun ColumnScope.ProfileScreenItem3() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(63.dp)
            .clickable {  },

    ) {
        Text(
            modifier = Modifier
                .padding(start = MEDIUM_PADDING)
                .align(Alignment.CenterStart),
            text = "Phản hồi",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h3,
            color = Color.Black
        )

        Divider(modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.BottomCenter))

    }
}