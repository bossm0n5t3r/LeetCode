class Solution:
    def fib(self, n: int) -> int:
        memo = {0: 0, 1: 1}
        return self.__recursion(n, memo)

    def __recursion(self, n: int, memo: dict):
        if n not in memo:
            memo[n] = self.__recursion(n - 1, memo) + self.__recursion(n - 2, memo)
        return memo[n]

    def test(self):
        tests = [
            [2, 1],
            [3, 2],
            [4, 3],
        ]
        for test in tests:
            n, expect_result = test
            result = self.fib(n)
            print(result)
            print(result == expect_result)


if __name__ == '__main__':
    Solution().test()
