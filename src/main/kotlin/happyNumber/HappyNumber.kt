package happyNumber

class HappyNumber {
    fun isHappy(n: Int): Boolean {
        var number = n
        while (number != 1 && number != 4) {
            var sum = 0
            while (number > 0) {
                sum += (number % 10) * (number % 10)
                number /= 10
            }
            number = sum
        }
        return number == 1
    }
}
