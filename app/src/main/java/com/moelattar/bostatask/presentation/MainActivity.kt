package com.moelattar.bostatask.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.moelattar.bostatask.presentation.screens.PickAreaScreen
import com.moelattar.bostatask.presentation.ui.theme.BostaTaskTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BostaTaskTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PickAreaScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
