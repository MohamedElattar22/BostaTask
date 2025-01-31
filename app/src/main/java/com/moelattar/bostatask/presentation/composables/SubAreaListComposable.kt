package com.moelattar.bostatask.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.moelattar.bostatask.domain.models.District


@Composable
fun SubAreaList(subAreas: List<District>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.surfaceDim)
    ) {
        subAreas.forEach { subArea ->
            SubAreaItem(subArea)
        }
    }
}
