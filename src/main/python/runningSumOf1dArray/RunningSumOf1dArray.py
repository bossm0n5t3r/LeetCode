class Solution:
    def runningSum(self, nums: list[int]) -> list[int]:
        return [sum(nums[: i + 1]) for i in range(len(nums))]

    def test(self):
        tests = [
            [[1, 2, 3, 4], [1, 3, 6, 10]],
            [[1, 1, 1, 1, 1], [1, 2, 3, 4, 5]],
            [[3, 1, 2, 10, 1], [3, 4, 6, 16, 17]],
        ]
        for test in tests:
            nums, expect_result = test
            result = self.runningSum(nums)
            print(result)
            print(result == expect_result)


if __name__ == "__main__":
    Solution().test()
