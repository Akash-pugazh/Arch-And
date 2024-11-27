package com.pugazh.arch_apps.mvi


class CounterViewModel: BaseViewModel<CounterReducer.CounterState, CounterReducer.CounterIntent, CounterReducer.CounterEffect>(
    initialState = CounterReducer.CounterState.initial(),
    reducer = CounterReducer()
) {

    fun handleIntents (intent: CounterReducer.CounterIntent) {
        when (intent) {
            is CounterReducer.CounterIntent.Increment -> sendIntent(CounterReducer.CounterIntent.Increment)
            is CounterReducer.CounterIntent.Decrement -> sendIntent(CounterReducer.CounterIntent.Decrement)
        }
    }


}

//sealed class CounterIntent {
//    data object Increment: CounterIntent()
//    data object Decrement: CounterIntent()
//}