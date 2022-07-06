class Solution:
    def fib(self, n: int) -> int:
        cnt = 0
        a, b = 0, 1
        while cnt < n:
            a, b = b, a + b
            cnt += 1
        return a

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
