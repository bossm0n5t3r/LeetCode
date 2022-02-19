package uniquePaths

import java.math.BigInteger
import kotlin.math.min

class UniquePaths {
    fun uniquePaths(m: Int, n: Int): Int {
        val min = min(m - 1, n - 1)
        val sum = m + n - 2
        var numerator = BigInteger("1")
        var denominator = BigInteger("1")
        for (i in 0 until min) {
            numerator = numerator.multiply(BigInteger((sum - i).toString()))
            denominator = denominator.multiply(BigInteger((i + 1).toString()))
        }
        return (numerator.divide(denominator)).toInt()
    }
}
