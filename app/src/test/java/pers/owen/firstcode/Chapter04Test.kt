package pers.owen.firstcode

import org.junit.Test

sealed class Result
class Success(val msg: String) : Result()
class Failure(val error:Exception) : Result()

class Chapter04Test {
    // lateinit表示延迟初始化

    // sealed class改造成密封类
    @Test
    fun getResultMsg(result: Result) = when (result) {
        is Success -> result.msg
        is Failure -> "Error is ${result.error.message}"
    }
}