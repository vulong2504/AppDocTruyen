package com.vungoclong.ui.screen.main.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vungoclong.ui.theme.MEDIUM_PADDING
import com.vungoclong.ui.theme.colorMain
import com.vungoclong.viewmodel.main.search.SearchScreenViewModel

@Composable
fun SearchScreen(
    viewModel: SearchScreenViewModel = viewModel()
) {
    Column(
        modifier = Modifier
        .fillMaxSize()
        .padding(MEDIUM_PADDING)
    ) {

        val focusManager = LocalFocusManager.current

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
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
                },
            ),
        )


    }

}