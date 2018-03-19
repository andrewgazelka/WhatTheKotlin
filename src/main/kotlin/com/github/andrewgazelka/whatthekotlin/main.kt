package com.github.andrewgazelka.whatthekotlin

import java.math.BigInteger

/*

also null safety is pretty cool

elvis operator `?:`

val name = ship?.captain?.name ?: "unknown"
This assigns "unknown" to name if name ship, captain, or name are null

 */

fun main(args: Array<String>)
{
    println("Fibonachi test")
    val fibonachi = fibonachi(BigInteger.ZERO, BigInteger.ONE, BigInteger.valueOf(100))
    println("Result: $fibonachi\n")

    println("Factorial test")
    val factorial = factorial(BigInteger.valueOf(100))
    println("Result: $factorial\n")

    println("Added ")
    println("Result: ${factorial+fibonachi}\n")
}

tailrec fun fibonachi(a: BigInteger, b: BigInteger, n: BigInteger): BigInteger
{
    return if ( n == BigInteger.ZERO) a else fibonachi(b, a + b, n - BigInteger.ONE)
}

fun factorial(a: BigInteger): BigInteger
{
    var result = BigInteger.ONE

    val two = BigInteger.valueOf(2)
    for(i in two..a)
    {
        result*=i
    }
    return result
}

// operator overloading and an extension function
operator fun ClosedRange<BigInteger>.iterator(): Iterator<BigInteger> {
    return object: Iterator<BigInteger>
    {
        var current = start
        val final = endInclusive

        override fun hasNext(): Boolean {
            return current <= final
        }

        override fun next(): BigInteger {
            return current++
        }

    }
}

