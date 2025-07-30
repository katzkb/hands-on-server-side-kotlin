package fizzbuzz.ifexpr
@Suppress("MagicNumber")
fun fizzbuzz(i: Int): String {
    return if (i % 15 == 0) {
        "FizzBuzz"
    } else if (i % 3 == 0) {
        "Fizz"
    } else if (i % 5 == 0) {
        "Buzz"
    } else {
        "$i"
    }
}

@Suppress("MagicNumber")
fun main(args: Array<String>) {
    val n = 20
    for (i in 1..n) {
        println(fizzbuzz(i))
    }
}
