package com.pugazh.arch_apps.mvi

import androidx.compose.runtime.*

class CounterReducer: IReducer<CounterReducer.CounterState, CounterReducer.CounterIntent, CounterReducer.CounterEffect> {

    @Immutable
    data class CounterState(val count: Int): IReducer.State {
        companion object {
            fun initial() = CounterState(0)
        }
    }


    @Immutable
    sealed class CounterIntent: IReducer.Intent {
        data object Increment: CounterIntent()
        data object Decrement: CounterIntent()
    }


    @Immutable
    sealed class CounterEffect: IReducer.Effect {
        data object navigateBack: CounterEffect()
        data object reset: CounterEffect()
    }

    override fun reduce(state: CounterState, intent: CounterIntent): Pair<CounterState, CounterEffect?> {
        return  when (intent) {
            is CounterIntent.Increment -> CounterState(state.count + 1) to null
            is CounterIntent.Decrement -> CounterState(state.count - 1) to null
        }
    }

}