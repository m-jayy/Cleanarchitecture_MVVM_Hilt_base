package com.mohsin.cleanarchitecture_base.domain.helpers

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

object Coroutines {
    fun main(work: suspend (() -> Unit)) =
            CoroutineScope(Dispatchers.Main).launch {
                work()
            }

    fun io(work: suspend () -> Unit) =
            CoroutineScope(Dispatchers.IO).launch {
                work()
            }

    fun default(work: suspend () -> Unit) =
            CoroutineScope(Dispatchers.Default).launch {
                work()
            }
}