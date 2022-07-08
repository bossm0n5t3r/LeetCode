class Solution:
    def isInterleave(self, s1: str, s2: str, s3: str) -> bool:
        m, n, o = len(s1), len(s2), len(s3)
        if o != m + n:
            return False
        dp = [False] * (n + 1)
        for r in range(m + 1):
            for c in range(n + 1):
                if r == 0 and c == 0:
                    dp[c] = True
                elif r == 0:
                    dp[c] = (
                        dp[c - 1] and s2[c - 1] == s3[r + c - 1]
                    )
                elif c == 0:
                    dp[c] = (
                        dp[c] and s1[r - 1] == s3[r + c - 1]
                    )
                else:
                    dp[c] = (
                        (dp[c - 1] and s2[c - 1] == s3[r + c - 1]) or
                        (dp[c] and s1[r - 1] == s3[r + c - 1])
                    )
        return dp[n]

    def test(self):
        tests = [
            ["aabcc", "dbbca", "aadbbcbcac", True],
            ["aabcc", "dbbca", "aadbbbaccc", False],
            ["", "", "", True],
        ]
        for test in tests:
            s1, s2, s3, expect_result = test
            result = self.isInterleave(s1, s2, s3)
            print(result == expect_result)


if __name__ == '__main__':
    Solution().test()
