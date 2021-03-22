package pers.owen.firstcode

import org.junit.Test
//import pers.owen.firstcode.`interface`.Result

sealed class Result
class Success(val msg: String) : Result()
class Failure(val error:Exception) : Result()

class Chapter04Test {
    // sealed class改造成密封类
    @Test
    fun getResultMsg(result: Result) = when (result) {
        is Success -> result.msg
        is Failure -> "Error is ${result.error.message}"
    }
}