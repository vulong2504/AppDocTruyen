package com.vungoclong.ui.screen.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.vungoclong.ui.theme.*
import com.vungoclong.viewmodel.welcome.WelcomeScreenViewModel
import com.vungoclong.util.WelcomePage

@OptIn(ExperimentalPagerApi::class)
@Composable
fun WelcomeScreen(
    welcomeScreenViewModel: WelcomeScreenViewModel = viewModel(),
    navigateClick: () -> Unit,
) {

    val pages = listOf(
        WelcomePage.First,
        WelcomePage.Second,
        WelcomePage.Third
    )
    val pagerState = rememberPagerState()
    val context = LocalContext.current

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        HorizontalPager(
            modifier = Modifier
                .fillMaxWidth(),
            count = pages.size,
            state = pagerState
        ) { page ->
            PagerScreen(
                pages[page],
                navigateClick={
                    welcomeScreenViewModel.savaWelcomeScreenState(context)
                    navigateClick()
                }
            )
        }

        HorizontalPagerIndicator(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = LARGE_PADDING),
            pagerState = pagerState,
            activeColor = colorMain,
            indicatorHeight = SMALL_PADDING,
            indicatorWidth = SMALL_PADDING,

            )
    }
}

@Composable
fun PagerScreen(
    welcomePage: WelcomePage,
    navigateClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(colorBackground),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth(0.5f),
            painter = painterResource(id = welcomePage.image),
            contentDescription = "Pager Image"
        )
        Text(
            modifier = Modifier
                .padding(horizontal = 25.dp),
            text = welcomePage.content,
            color = colorMain,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h1
        )
        if (welcomePage is WelcomePage.Third) {
            Button(
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .height(40.dp),
                shape = RoundedCornerShape(SMALL_PADDING),
                colors = ButtonDefaults.buttonColors(backgroundColor = colorMain),
                onClick = {
                    navigateClick()
                },
            ) {
                Text(
                    text = "Bắt đầu",
                    color = Color.White,
                    style = Typography.h5,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PagerScreenPre() {
    AppDocTruyenTheme {
        PagerScreen(WelcomePage.Third, {})
    }
}