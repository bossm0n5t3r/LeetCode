class Solution:
    def lengthOfLIS(self, nums: list[int]) -> int:
        n = len(nums)
        dp = [1] * n
        for i in range(n):
            for j in range(i):
                if nums[i] > nums[j] and dp[i] < dp[j] + 1:
                    dp[i] = dp[j] + 1
        return max(dp)

    def test(self):
        tests = [
            [[10, 9, 2, 5, 3, 7, 101, 18], 4],
            [[0, 1, 0, 3, 2, 3], 4],
            [[7, 7, 7, 7, 7, 7, 7], 1],
        ]
        for test in tests:
            nums, expect_result = test
            result = self.lengthOfLIS(nums)
            print(result)
            print(result == expect_result)


if __name__ == "__main__":
    Solution().test()
