@file:OptIn(ExperimentalMaterialApi::class)

package com.vungoclong.ui.screen.main.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.vungoclong.model.Book
import com.vungoclong.ui.theme.*
import com.vungoclong.util.Helper
import com.vungoclong.util.State
import com.vungoclong.viewmodel.main.search.SearchScreenViewModel

@Composable
fun SearchScreen(
    viewModel: SearchScreenViewModel = viewModel(),
//    onItemClick: (Book) -> Unit
) {
    Surface(
        color = colorBackground,
        modifier = Modifier.fillMaxSize()
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {

            val focusManager = LocalFocusManager.current

            OutlinedTextField(
                modifier = Modifier
                    .padding(
                        start = MEDIUM_PADDING,
                        end = MEDIUM_PADDING,
                        top = MEDIUM_PADDING
                    )
                    .fillMaxWidth(),
                value = viewModel.text.value,
                onValueChange = {
                    if (it.length <= 60) {
                        viewModel.text.value = it
                    }
                },
                label = {
                    Text(
                        text = "Tìm truyện theo tên, tác giả",
                        style = MaterialTheme.typography.h5
                    )
                },
                textStyle = MaterialTheme.typography.h5,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = colorMain,
                    textColor = Color.Black,
                ),
                singleLine = true,
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null,
                    )
                },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Search
                ),
                keyboardActions = KeyboardActions(
                    onSearch = {
                        focusManager.clearFocus()
                        viewModel.searchStory()
                    },
                ),
            )
            
            Spacer(modifier = Modifier.height(1.dp))

            when (viewModel.searchState.value) {
                is State.Loading -> {
                    Box(modifier = Modifier.fillMaxSize()) {
                        CircularProgressIndicator(
                            modifier = Modifier.align(Alignment.Center),
                            color = colorMain
                        )
                    }
                }
                is State.NotFound -> {
                    Box(modifier = Modifier.fillMaxSize()) {
                        Text(
                            modifier = Modifier.align(Alignment.Center),
                            text = "Không tìm thấy truyện nào",
                            style = MaterialTheme.typography.h5,
                            color = colorMain
                        )
                    }
                }
                is State.None -> {

                }
                is State.Success -> {
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(SMALL_PADDING),
                        contentPadding = PaddingValues(all = MEDIUM_PADDING)
                    ) {
                        viewModel.listResult.value.forEach {
                            item {
                                SearchScreenItem(it, onItemClick = { })
                            }
                        }
                    }
                }
            }

        }

    }
}

@Composable
fun SearchScreenItem(
    book: Book,
    onItemClick: (Book) -> Unit
) {
    Card(
        modifier = Modifier
            .height(100.dp)
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
                    text = book.name!!,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.h5,
                    color = Color.Black

                )
                Text(
                    text = "Tác giả: ${book.author}",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.h6,
                    color = colorText2
                )
                Text(
                    text = "Thể loại: ${Helper.categoryArrayToString(book.category!!)}",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.h6,
                    color = colorText2
                )
            }
        }
    }

}