package me.bossm0n5t3r.leetcode.productofthelastknumbers

class ProductOfTheLastKNumbers {
    class ProductOfNumbers {
        private val numbers = mutableListOf<Int>()

        fun add(num: Int) {
            if (numbers.isEmpty() && num != 0) {
                numbers += num
                return
            }
            if (num == 0) {
                numbers.clear()
                return
            }
            numbers += numbers.last() * num
        }

        fun getProduct(k: Int): Int {
            if (k > numbers.size) return 0
            if (k == numbers.size) return numbers.last()
            return numbers.last() / numbers[numbers.size - k - 1]
        }
    }
}
