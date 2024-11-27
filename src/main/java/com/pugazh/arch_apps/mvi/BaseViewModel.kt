package com.pugazh.arch_apps.mvi

import android.util.Log
import kotlinx.coroutines.channels.*
import kotlinx.coroutines.flow.*
import kotlin.math.*


abstract class BaseViewModel<State : IReducer.State, Intent : IReducer.Intent, Effect : IReducer.Effect>(
    initialState: State, private val reducer: IReducer<State, Intent, Effect>
) {
    private val _state: MutableStateFlow<State> = MutableStateFlow(initialState)
    val state: StateFlow<State>
        get() = _state.asStateFlow()

    private val _event: MutableSharedFlow<Intent> = MutableSharedFlow()
    val event: SharedFlow<Intent>
        get() = _event.asSharedFlow()

    private val _effects = Channel<Effect>()
    val effect = _effects.receiveAsFlow()


    fun sendEffect(effect: Effect) {
        _effects.trySend(effect)
    }

    fun sendIntent(event: Intent) {
        // CENTRAL location ALL EVENTS HANDLING
        Log.e("EVENT", event.toString())
        val (newState, _) = reducer.reduce(_state.value, event)

        _state.tryEmit(newState)

    }

    fun sendEventForEffect(event: Intent) {
        val (newState, effect) = reducer.reduce(_state.value, event)

        _state.tryEmit(newState)

        effect?.let {
            sendEffect(it)
        }
    }

}

