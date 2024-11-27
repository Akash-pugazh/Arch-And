package com.pugazh.arch_apps.mvi.paired_devices

import com.pugazh.arch_apps.mvi.*

class PairedDevicesViewModel: BaseViewModel<PairedDevicesReducer.PairedDevicesState, PairedDevicesReducer.PairedDevicesIntent, PairedDevicesReducer.PairedDevicesEffect>(
    initialState = PairedDevicesReducer.PairedDevicesState.initial(),
    reducer = PairedDevicesReducer()
){




    fun handlePairedDevicesIntents(intent: PairedDevicesReducer.PairedDevicesIntent) {
        when (intent) {
            is PairedDevicesReducer.PairedDevicesIntent.LoadDevices -> sendIntent(PairedDevicesReducer.PairedDevicesIntent.LoadDevices)
            is PairedDevicesReducer.PairedDevicesIntent.updateError -> sendIntent(PairedDevicesReducer.PairedDevicesIntent.updateError(intent.error))
            is PairedDevicesReducer.PairedDevicesIntent.updateLoadingStatus -> sendIntent(PairedDevicesReducer.PairedDevicesIntent.updateLoadingStatus(intent.isLoading))
        }
    }

}