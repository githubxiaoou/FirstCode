package pers.owen.firstcode.c10test

interface Transformer<in T> {
    fun transformer(t: T): String
}