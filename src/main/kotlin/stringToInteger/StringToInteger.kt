package stringToInteger

import java.math.BigInteger

class StringToInteger {
    fun myAtoi(s: String): Int {
        return s.step1().step2().step3().step4().step5()
    }

    private fun String.step1(): Pair<Char, String> {
        return '+' to this.trim()
    }

    private fun Pair<Char, String>.step2(): Pair<Char, String> {
        return if (this.second.isNotEmpty() && this.second[0] == '-') {
            '-' to this.second.substring(1)
        } else {
            val tmp = if (this.second.isNotEmpty() && this.second[0] == '+') {
                this.second.substring(1)
            } else {
                this.second
            }
            this.first to tmp
        }
    }

    companion object {
        // Use companion object for testing
        fun Pair<Char, String>.step3(): Pair<Char, String> {
            var idx = 0
            while (idx < this.second.length && this.second[idx].isDigit()) {
                idx++
            }
            return this.first to this.second.substring(0, idx)
        }
    }

    private fun Pair<Char, String>.step4(): Pair<Char, BigInteger> {
        return if (this.second.isNotEmpty()) {
            this.first to this.second.toBigInteger()
        } else {
            this.first to BigInteger.valueOf(0L)
        }
    }

    private fun Pair<Char, BigInteger>.step5(): Int {
        val tmp = if (this.first == '-') {
            this.second.times(BigInteger.valueOf(-1L))
        } else {
            this.second
        }
        return when {
            tmp < BigInteger.valueOf(Int.MIN_VALUE.toLong()) -> {
                Int.MIN_VALUE
            }
            tmp > BigInteger.valueOf(Int.MAX_VALUE.toLong()) -> {
                Int.MAX_VALUE
            }
            else -> {
                tmp.toInt()
            }
        }
    }
}
