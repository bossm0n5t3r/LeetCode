package fizzBuzz

class FizzBuzz {
    fun fizzBuzz(n: Int): List<String> {
        val result = mutableListOf<String>()
        val fizz = "Fizz"
        val buzz = "Buzz"
        val fizzBuzz = "FizzBuzz"
        for (i in 1..n) {
            if (i % 15 == 0) {
                result.add(fizzBuzz)
            } else if (i % 3 == 0) {
                result.add(fizz)
            } else if (i % 5 == 0) {
                result.add(buzz)
            } else {
                result.add(i.toString())
            }
        }
        return result
    }
}
