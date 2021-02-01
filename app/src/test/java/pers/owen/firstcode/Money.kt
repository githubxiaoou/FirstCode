package pers.owen.firstcode

class Money(val value: Int) {

    operator fun plus(money: Money): Money {
        val sum = value + money.value
        return Money(sum)
    }

    operator fun plus(newValue: Int): Money {
        var sum = value + newValue
        return Money(sum);
    }
}