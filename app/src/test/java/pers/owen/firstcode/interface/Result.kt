package pers.owen.firstcode.`interface`

import java.lang.Exception

interface Result {
    class Success(val msg: String) : Result
    class Failure(val error:Exception) : Result
}