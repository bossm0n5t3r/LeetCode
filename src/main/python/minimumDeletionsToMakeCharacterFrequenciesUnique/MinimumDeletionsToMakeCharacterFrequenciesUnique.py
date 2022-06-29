import collections


class Solution:
    def minDeletions(self, s: str) -> int:
        cnt, res, used = collections.Counter(s), 0, set()
        for ch, freq in cnt.items():
            while freq > 0 and freq in used:
                freq -= 1
                res += 1
            used.add(freq)
        return res

    def test(self):
        tests = [
            ["aab", 0],
            ["aaabbbcc", 2],
            ["ceabaacb", 2],
            ["bbcebab", 2],
            ["abcabc", 3]
        ]
        for test in tests:
            s, expect_result = test
            result = self.minDeletions(s)
            print(result)
            print(result == expect_result)


if __name__ == '__main__':
    Solution().test()
