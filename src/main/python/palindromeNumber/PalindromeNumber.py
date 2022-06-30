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

    def isPalindromeAnother(self, x: int) -> bool:
        if x < 0 or (x % 10 == 0 and x != 0):
            return False
        reverted_number = 0
        while x > reverted_number:
            reverted_number = reverted_number * 10 + x % 10
            x //= 10
        return x == reverted_number or x == reverted_number // 10

    def test(self):
        tests = [
            [121, True],
            [-121, False],
            [10, False],
        ]
        for test in tests:
            x, expect_result = test
            print(self.isPalindrome(x) == expect_result)
            print(self.isPalindromeAnother(x) == expect_result)


if __name__ == '__main__':
    Solution().test()
