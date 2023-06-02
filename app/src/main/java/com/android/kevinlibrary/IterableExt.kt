package com.android.kevinlibrary

fun <T> Iterable<T>.randomTake(): T = this.shuffled().first()

class IterableExt {

}