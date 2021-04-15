package pers.owen.firstcode.c10test

interface Transformer<T> {
    fun transformer(t: T): String
}