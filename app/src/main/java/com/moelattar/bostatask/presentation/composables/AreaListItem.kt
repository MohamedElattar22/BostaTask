package com.moelattar.bostatask.presentation.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.moelattar.bostatask.domain.models.District

@Composable
@Stable
fun AreaListItem(
    modifier: Modifier = Modifier,
    areaName: String,
    subAreas: List<District>,
) {

    var expanded by remember { mutableStateOf(false) }

    Column {
        ListItem(
            modifier = Modifier.clickable { expanded = !expanded },
            headlineContent = {
                Text(
                    text = areaName,
                    fontSize = 14.sp

                )
            },
            trailingContent = {
                ExpandCollapseIcon(expanded) {
                    expanded = !expanded
                }
            }
        )

        AnimatedVisibility(visible = expanded) {
            SubAreaList(
                subAreas = subAreas
            )
        }

        HorizontalDivider(
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colorScheme.surfaceDim
        )
    }


}



