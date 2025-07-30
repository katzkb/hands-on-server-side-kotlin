package fizzbuzz.whenexpr

@Suppress("MagicNumber")
fun fizzbuzz(i: Int): String {
    return when {
        i % 15 == 0 -> "FizzBuzz"
        i % 3 == 0 -> "Buzz"
        i % 5 == 0 -> "Fizz"
        else -> "$i"
    }
}

@Suppress("MagicNumber")
fun main(args: Array<String>) {
    val n = 20
    for (i in 1..n) {
        println(fizzbuzz(i))
    }
}
