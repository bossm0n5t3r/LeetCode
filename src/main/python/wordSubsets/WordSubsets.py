class Solution:
    def wordSubsets(self, words1: list[str], words2: list[str]) -> list[str]:
        def count(word):
            ans = [0] * 26
            for letter in word:
                ans[ord(letter) - ord('a')] += 1
            return ans

        bmax = [0] * 26
        for b in words2:
            for i, c in enumerate(count(b)):
                bmax[i] = max(bmax[i], c)

        ans = []
        for a in words1:
            if all(x >= y for x, y in zip(count(a), bmax)):
                ans.append(a)
        return ans

    def test(self):
        tests = [
            [["amazon", "apple", "facebook", "google", "leetcode"], ["e", "o"], ["facebook", "google", "leetcode"]],
            [["amazon", "apple", "facebook", "google", "leetcode"], ["l", "e"], ["apple", "google", "leetcode"]],
        ]
        for test in tests:
            words1, words2, expect_result = test
            result = self.wordSubsets(words1, words2)
            print(result)
            print(result == expect_result)


if __name__ == '__main__':
    Solution().test()
