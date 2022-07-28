class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        count = [0] * 26
        for c in s:
            count[ord(c) - ord('a')] += 1
        for c in t:
            count[ord(c) - ord('a')] -= 1
        for c in count:
            if c != 0:
                return False
        return True

    def test(self):
        tests = [
            ["anagram", "nagaram", True],
            ["rat", "car", False],
        ]
        for test in tests:
            s, t, expect_result = test
            result = self.isAnagram(s, t)
            print(result == expect_result)


if __name__ == '__main__':
    Solution().test()
