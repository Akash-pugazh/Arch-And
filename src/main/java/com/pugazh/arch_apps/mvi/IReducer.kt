package com.pugazh.arch_apps.mvi

interface IReducer<State: IReducer.State, Intent: IReducer.Intent, Effect: IReducer.Effect> {
    interface State
    interface Intent
    interface Effect
    fun reduce(state: State, intent: Intent): Pair<State, Effect?>
}