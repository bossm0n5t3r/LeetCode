class Solution:
    def canJump(self, nums: list[int]) -> bool:
        goal = len(nums) - 1
        for i in range(len(nums) - 1, -1, -1):
            if i + nums[i] >= goal:
                goal = i
        return not goal

    def test(self):
        tests = [
            [[2, 3, 1, 1, 4], True],
            [[3, 2, 1, 0, 4], False],
        ]
        for test in tests:
            nums, expect_result = test
            result = self.canJump(nums)
            print(result == expect_result)


if __name__ == "__main__":
    Solution().test()
