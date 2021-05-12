package happyNumber

import kotlin.math.pow

class HappyNumber {
    fun isHappy(n: Int): Boolean {
        val set = mutableSetOf<Int>()
        var number = n
        while (true) {
            if (number == 1) return true
            if (set.contains(number)) return false
            set.add(number)
            number = sumOfSquares(getDigits(number))
        }
    }

    private fun getDigits(n: Int): List<Int> {
        val result = mutableListOf<Int>()
        var number = n
        while (number > 0) {
            val remainder = number % 10
            result.add(remainder)
            number /= 10
        }
        return result
    }

    private fun sumOfSquares(digits: List<Int>): Int {
        return digits.sumOf { it.toDouble().pow(2).toInt() }
    }
}
