package com.moelattar.bostatask.presentation.composables

import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ExpandCollapseIcon(expanded: Boolean, onClick: () -> Unit) {
    Icon(
        modifier = Modifier.clickable(
            interactionSource = null,
            indication = null
        ) { onClick() },
        imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
        contentDescription = "Expand/Collapse"
    )
}

