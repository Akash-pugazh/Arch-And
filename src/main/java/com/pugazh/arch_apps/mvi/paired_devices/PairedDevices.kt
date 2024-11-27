package com.pugazh.arch_apps.mvi.paired_devices

import androidx.compose.material3.*
import androidx.compose.runtime.*
import kotlinx.coroutines.*

@Composable
fun PairedDevicesScreen(pairedDevicesViewModel: PairedDevicesViewModel) {

    val state by pairedDevicesViewModel.state.collectAsState()


    LaunchedEffect(Unit) {
        pairedDevicesViewModel.handlePairedDevicesIntents(PairedDevicesReducer.PairedDevicesIntent.updateLoadingStatus(true))
        delay(2000)

        pairedDevicesViewModel.handlePairedDevicesIntents(PairedDevicesReducer.PairedDevicesIntent.LoadDevices)
    }

    Text("Devices")


    if (state.isLoading) {
        Text("Loading.....")
    } else {
        state.devices.forEach {
            Text(it.name)
        }
    }

}