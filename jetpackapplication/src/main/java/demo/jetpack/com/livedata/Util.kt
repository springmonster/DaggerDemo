package demo.jetpack.com.livedata

import java.util.*

fun IntRange.random() = (Random().nextInt((endInclusive + 1) - start) + start).toString().padStart(4, '0')