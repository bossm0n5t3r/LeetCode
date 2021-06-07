package countPrimes

class CountPrimes {
    fun countPrimes(n: Int): Int {
        if (n <= 2) return 0
        val primes = mutableListOf(2)
        for (i in 3 until n) {
            var isPrime = true
            for (prime in primes) {
                if (prime > n / prime) break
                if (i % prime == 0) {
                    isPrime = false
                    break
                }
            }
            if (isPrime) primes.add(i)
        }
        return primes.size
    }
}
