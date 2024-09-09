package com.coroutinelab.coreui.mvi

import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

interface MVIContract<STATE, EFFECTS, EVENT> : MVIContractEVENT<EVENT> {
    val state: StateFlow<STATE>
    val effect: SharedFlow<EFFECTS>

    override fun event(event: EVENT)
}

interface MVIContractEVENT<EVENT> {
    fun event(event: EVENT)
}
