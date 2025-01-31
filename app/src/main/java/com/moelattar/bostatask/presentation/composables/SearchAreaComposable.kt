package com.moelattar.bostatask.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moelattar.bostatask.presentation.ui.theme.BostaTaskTheme


@Composable
fun SearchAreaTextFieldComposable(
    modifier: Modifier = Modifier,
    searchQuery: String = "",
    onSearchQueryChange: (String) -> Unit = {},
) {
    val leadingIcon = when (searchQuery.isNotEmpty()) {
        true -> {
            Icons.Default.Close
        }

        false -> {
            Icons.Default.Search
        }
    }
    Box(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(
                shape = RoundedCornerShape(16.dp),
                color = MaterialTheme.colorScheme.background
            )
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.onBackground,
                shape = RoundedCornerShape(16.dp)
            )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            TextField(

                colors = TextFieldDefaults.colors(

                ).copy(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                ),
                value = searchQuery,
                onValueChange = {
                    onSearchQueryChange(it)
                },
                trailingIcon = {
                    IconButton(
                        onClick = {
                            if (searchQuery.isNotEmpty()) {
                                onSearchQueryChange("")
                            }

                        }
                    ) {
                        Icon(
                            imageVector = leadingIcon,
                            tint = Color.Gray,
                            contentDescription = "Search"
                        )
                    }
                },
                label = {
                    Text(
                        "City/Area",
                        color = Color.Gray,
                        fontSize = 14.sp
                    )

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .border(
                        width = 1.dp,
                        color = Color.Transparent,
                        shape = RoundedCornerShape(8.dp)
                    )

            )
        }


    }

}

@Preview
@Composable
private fun SearchAreaTextFieldComposablePreview() {
    BostaTaskTheme {
        SearchAreaTextFieldComposable()

    }
}