class Solution:
    def minPathSum(self, grid: list[list[int]]) -> int:
        m, n = len(grid), len(grid[0])
        dp = [[0] * n for _ in range(m)]
        dp[0][0] = grid[0][0]
        for r in range(1, m):
            dp[r][0] = dp[r - 1][0] + grid[r][0]
        for c in range(1, n):
            dp[0][c] = dp[0][c - 1] + grid[0][c]
        for r in range(1, m):
            for c in range(1, n):
                dp[r][c] = min(dp[r - 1][c], dp[r][c - 1]) + grid[r][c]
        return dp[-1][-1]

    def test(self):
        tests = [
            [[[1, 3, 1], [1, 5, 1], [4, 2, 1]], 7],
            [[[1, 2, 3], [4, 5, 6]], 12],
        ]
        for test in tests:
            grid, expect_result = test
            result = self.minPathSum(grid)
            print(result)
            print(result == expect_result)


if __name__ == "__main__":
    Solution().test()
