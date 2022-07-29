class Solution:
    def findAndReplacePattern(self, words: list[str], pattern: str) -> list[str]:
        def match(word):
            m1, m2 = {}, {}
            for w, p in zip(word, pattern):
                if w not in m1:
                    m1[w] = p
                if p not in m2:
                    m2[p] = w
                if (m1[w], m2[p]) != (p, w):
                    return False
            return True

        return list(filter(match, words))

    def test(self):
        tests = [
            [["abc", "deq", "mee", "aqq", "dkd", "ccc"], "abb", ["mee", "aqq"]],
            [["a", "b", "c"], "a", ["a", "b", "c"]],
        ]
        for test in tests:
            words, pattern, expect_result = test
            result = self.findAndReplacePattern(words, pattern)
            print(result)
            print(result == expect_result)


if __name__ == '__main__':
    Solution().test()
