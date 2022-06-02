package beautifulArrangement2

class BeautifulArrangement2 {
    fun constructArray(n: Int, k: Int): IntArray {
        val result = IntArray(n) { 0 }
        val sign = (k % 2) == 1
        var start = 1
        var startCount = if (sign) n - (k / 2) else k / 2
        var end = n
        var endCount = n - startCount
        var idx = 0
        while (idx < n) {
            if (startCount == 0) {
                while (endCount-- > 0) {
                    result[idx++] = end--
                }
                break
            }
            if (endCount == 0) {
                while (startCount-- > 0) {
                    result[idx++] = start++
                }
                break
            }
            result[idx] = if (idx % 2 == 0) {
                startCount--
                start++
            } else {
                endCount--
                end--
            }
            idx++
        }
        return result
    }
}
