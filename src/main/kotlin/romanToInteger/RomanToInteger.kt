package romanToInteger

class RomanToInteger {
    fun romanToInt(s: String): Int {
        var result = 0
        var prev = '0'
        for (i in s.length - 1 downTo 0) {
            val cur = s[i]
            when (cur) {
                'I' -> result = if (prev == 'X' || prev == 'V') result - 1 else result + 1
                'V' -> result += 5
                'X' -> result = if (prev == 'L' || prev == 'C') result - 10 else result + 10
                'L' -> result += 50
                'C' -> result = if (prev == 'D' || prev == 'M') result - 100 else result + 100
                'D' -> result += 500
                'M' -> result += 1000
            }
            prev = cur
        }
        return result
    }
}
