package com.pugazh.arch_apps.mvc

class CounterController (val counterModel: CounterModel) {

    fun incrementCount() {
        counterModel.count++
    }

    fun decrementCount() {
        counterModel.count--
    }

    fun getCount(): Int {
        return counterModel.count
    }
}