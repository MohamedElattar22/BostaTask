package com.moelattar.bostatask.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moelattar.bostatask.presentation.ui.theme.BostaTaskTheme

@Composable
fun UncoveredBadgeComposable(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .wrapContentWidth()
            .height(32.dp)
            .padding(horizontal = 16.dp)
            .background(
                color = MaterialTheme.colorScheme.background,
                shape = RoundedCornerShape(8.dp)
            )
    ) {
        Text(
            text = "Uncovered",
            fontSize = 13.sp,

            modifier = Modifier
                .padding(6.dp)
                .align(Alignment.Center),
            color = Color.Gray
        )


    }


}


@Preview
@Composable
private fun UncoveredBadgeComposablePreview() {
    BostaTaskTheme {
        UncoveredBadgeComposable()
    }

}