class Solution:
    def isPalindrome(self, x: int) -> bool:
        if x < 0:
            return False
        str_x = list(str(x))
        length = len(str_x)
        idx = 0
        while idx <= length // 2:
            if str_x[idx] != str_x[length - 1 - idx]:
                return False
            idx += 1
        return True

    def test(self):
        tests = [
            [121, True],
            [-121, False],
            [10, False],
        ]
        for test in tests:
            x, expect_result = test
            result = self.isPalindrome(x)
            print(result == expect_result)


if __name__ == '__main__':
    Solution().test()
