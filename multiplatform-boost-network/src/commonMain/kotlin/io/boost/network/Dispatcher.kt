package io.boost.network

import kotlinx.coroutines.CoroutineDispatcher


internal expect val ApplicationDispatcher: CoroutineDispatcher

internal expect val UIDispatcher: CoroutineDispatcher