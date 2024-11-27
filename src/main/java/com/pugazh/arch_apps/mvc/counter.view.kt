package com.pugazh.arch_apps.mvc

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import com.pugazh.arch_apps.mvi.*


interface CounterView {
    fun setContent(content: @Composable () -> Unit)
}

@Composable
fun CounterView(counterController: CounterController) {
    var count by remember { mutableIntStateOf(counterController.getCount()) }


    Row {
        Button(onClick = {
            counterController.decrementCount()
            count = counterController.getCount()
        }) {
            Text("-")
        }
        Text(text = count.toString())
        Button(onClick = {
            counterController.incrementCount()
            count = counterController.getCount()
        }) {
            Text("+")
        }

    }

}