package com.moelattar.bostatask.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.moelattar.bostatask.R
import com.moelattar.bostatask.presentation.composables.DeliveryAreaBottomSheetComposable
import com.moelattar.bostatask.presentation.ui.theme.BostaTaskTheme
import com.moelattar.bostatask.presentation.viewmodel.CitiesContract
import com.moelattar.bostatask.presentation.viewmodel.CitiesViewModel
import kotlinx.coroutines.flow.collectLatest

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PickAreaScreen(
    modifier: Modifier = Modifier,
    viewModel: CitiesViewModel = hiltViewModel(),

    ) {
    val state by viewModel.viewState.collectAsStateWithLifecycle()
    var isLoading by rememberSaveable { mutableStateOf(true) }
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    var showBottomSheet by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) {
        viewModel.processIntent(
            CitiesContract.CitiesActions.GetAllCities
        )
    }

    LaunchedEffect(sheetState.isVisible) {
        if (!sheetState.isVisible) {
            showBottomSheet = false
        }
    }

    LaunchedEffect(Unit) {

        viewModel.singleEvent.collectLatest { event ->
            when (event) {
                CitiesContract.CitiesEvents.CitiesLoadedSuccessfully -> {
                    isLoading = false
                }

                CitiesContract.CitiesEvents.ErrorLoadingCities -> {
                    isLoading = false
                }

                is CitiesContract.CitiesEvents.ShowToast -> {

                }
            }

        }

    }
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Button(
            onClick = {
                showBottomSheet = true
            }
        ) {
            Text(text = stringResource(R.string.pick_area))
        }
        if (showBottomSheet) {
            DeliveryAreaBottomSheetComposable(
                query = state.query,
                loadingContent = isLoading,
                onDismiss = {
                    showBottomSheet = false
                },
                citiesList = state.cities,
                sheetState = sheetState,
                onQueryChange = {
                    viewModel.processIntent(
                        CitiesContract.CitiesActions.OnQueryChange(it)
                    )
                    viewModel.processIntent(
                        CitiesContract.CitiesActions.FilterCitiesByName(it)
                    )
                }

            )
        }
    }

}

@Preview(showSystemUi = true)
@Composable
private fun DeliveryBottomSheetPreview() {
    BostaTaskTheme {
        PickAreaScreen()
    }

}