class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        def factorial(memo, m):
            if m not in memo:
                memo[m] = factorial(memo, m - 1) * m
            return memo[m]

        memo = {0: 1, 1: 1}
        target_m, target_n = m - 1, n - 1
        factorial_m_n = factorial(memo, target_m + target_n)
        return factorial_m_n // memo[target_m] // memo[target_n]

    def test(self):
        tests = [
            [3, 7, 28],
            [3, 2, 3],
        ]
        for test in tests:
            m, n, expect_result = test
            result = self.uniquePaths(m, n)
            print(result)
            print(result == expect_result)


if __name__ == '__main__':
    Solution().test()
