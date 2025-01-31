package com.moelattar.bostatask.presentation.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moelattar.bostatask.R
import com.moelattar.bostatask.domain.models.City


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeliveryAreaBottomSheetComposable(
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit = {},
    loadingContent: Boolean = false,
    citiesList: List<City>,
    query: String = "",
    sheetState: SheetState,
    onQueryChange: (String) -> Unit = {},
) {
    val scope = rememberCoroutineScope()
    ModalBottomSheet(
        onDismissRequest = {
            onDismiss()
        },
        modifier = modifier
            .fillMaxSize()
            .padding(top = 36.dp),
        sheetState = sheetState,
        dragHandle = {

        },
        containerColor = MaterialTheme.colorScheme.background


    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 8.dp, start = 16.dp, end = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(R.string.choose_area_title),
                modifier = Modifier.weight(1f),
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Bold
            )

            IconButton(
                onClick = {
                    onDismiss()
                }

            ) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = stringResource(R.string.close)
                )

            }
        }

        SearchAreaTextFieldComposable(
            modifier = Modifier.padding(horizontal = 16.dp),
            searchQuery = query,
            onSearchQueryChange = {
                onQueryChange(it)
            }
        )

        if (loadingContent) {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }

        } else {
            LazyColumn(

            ) {
                items(citiesList, key = { it.cityId }) { city ->
                    AreaListItem(
                        areaName = city.cityName,
                        subAreas = city.districts
                    )
                }
            }
        }


    }


}


