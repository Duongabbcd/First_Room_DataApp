package gst.trainingcourse.studen_school_management.utils

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherProvider {
    val main : CoroutineDispatcher
    val default:CoroutineDispatcher
    val io :CoroutineDispatcher
    val undefined :CoroutineDispatcher
}