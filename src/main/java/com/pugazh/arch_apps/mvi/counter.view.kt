package com.pugazh.arch_apps.mvi

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*

@Composable
fun CounterView(counterViewModel: CounterViewModel) {

    Row {
        Button(onClick = {
            counterViewModel.handleIntents(CounterReducer.CounterIntent.Decrement)
        }) {
            Text("-")
        }
        Text(text = counterViewModel.state.collectAsState().value.toString())
        Button(onClick = {
            counterViewModel.handleIntents(CounterReducer.CounterIntent.Increment)
        }) {
            Text("+")
        }
    }
}