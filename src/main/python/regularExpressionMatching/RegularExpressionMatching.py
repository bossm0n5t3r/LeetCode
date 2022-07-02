class Solution:
    def isMatch(self, text, pattern):
        if not pattern:
            return not text
        first_match = bool(text) and pattern[0] in {text[0], '.'}
        if len(pattern) >= 2 and pattern[1] == '*':
            return (self.isMatch(text, pattern[2:]) or
                    first_match and self.isMatch(text[1:], pattern))
        else:
            return first_match and self.isMatch(text[1:], pattern[1:])

    def test(self):
        tests = [
            ["aa", "a", False],
            ["aa", "a*", True],
            ["ab", ".*", True],
            ["aab", "c*a*b", True],
            ["aaa", "aaaa", False],
            ["aaa", "ab*ac*a", True],
            ["mississippi", "mis*is*ip*.", True],
            ["ab", ".*c", False],
            ["aaa", "a*a", True],
            ["a", "ab*", True],
            ["a", "ab*c*", True],
            ["a", "ab*c*d*e*", True],
        ]
        for test in tests:
            s, p, expect_result = test
            result = self.isMatch(s, p)
            print(result == expect_result)


if __name__ == '__main__':
    Solution().test()
