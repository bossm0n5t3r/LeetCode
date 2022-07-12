class Solution:
    def minCostClimbingStairs(self, cost: list[int]) -> int:
        local_max = 999000
        dp = [local_max] * (len(cost) + 1)
        for i in range(len(cost) + 1):
            if i == 0:
                dp[i] = min(dp[i], cost[i])
            elif i == 1:
                dp[i] = min(dp[i], cost[i], dp[i - 1] + cost[i - 1])
            elif i == 2:
                dp[i] = min(dp[i], cost[i - 1], cost[i - 2])
            elif i == 3:
                dp[i] = min(dp[i], dp[i - 1] + cost[i - 1], cost[i - 2])
            else:
                dp[i] = min(dp[i], dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2])
        return dp[-1]

    def test(self):
        tests = [
            [[10, 15, 20], 15],
            [[1, 100, 1, 1, 1, 100, 1, 1, 100, 1], 6],
        ]
        for test in tests:
            cost, expect_result = test
            result = self.minCostClimbingStairs(cost)
            print(result)
            print(result == expect_result)


if __name__ == "__main__":
    Solution().test()
