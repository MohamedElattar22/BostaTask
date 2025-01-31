package com.moelattar.bostatask.presentation.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.moelattar.bostatask.domain.models.District

@Composable
fun SubAreaItem(
    subArea: District,

    ) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
    ) {
        if (subArea.pickupAvailability && subArea.dropOffAvailability) {
            Text(
                text = subArea.districtName,
                modifier = Modifier.padding(8.dp),
            )
        } else {
            Text(
                text = subArea.districtName,
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f),
                color = Color.Gray
            )
            UncoveredBadgeComposable()
        }
    }
}
