package com.pugazh.arch_apps.mvi.paired_devices

import androidx.compose.runtime.*
import com.pugazh.arch_apps.mvi.*


data class Device(val name: String, val id: Int)

class PairedDevicesReducer: IReducer<PairedDevicesReducer.PairedDevicesState, PairedDevicesReducer.PairedDevicesIntent, PairedDevicesReducer.PairedDevicesEffect> {

    @Immutable
    data class PairedDevicesState(
        val isLoading: Boolean,
        val devices: List<Device>,
        val error: String?
    ): IReducer.State {
        companion object {
            fun initial() = PairedDevicesState(false, emptyList(), null)
        }
    }

    @Immutable
    sealed class PairedDevicesIntent: IReducer.Intent {
        data class updateLoadingStatus(val isLoading: Boolean): PairedDevicesIntent()
        data object LoadDevices: PairedDevicesIntent()
        data class updateError(val error: String): PairedDevicesIntent()
    }


    @Immutable
    sealed interface PairedDevicesEffect: IReducer.Effect

    override fun reduce(state: PairedDevicesState, intent: PairedDevicesIntent): Pair<PairedDevicesState, PairedDevicesEffect?> {
        return when (intent) {
            is PairedDevicesIntent.updateLoadingStatus -> state.copy(isLoading = intent.isLoading) to null
            is PairedDevicesIntent.LoadDevices -> state.copy(devices = listOf(Device("GG Scale", 123)), isLoading = false) to null
            is PairedDevicesIntent.updateError -> state.copy(error = intent.error) to null
        }
    }

}

