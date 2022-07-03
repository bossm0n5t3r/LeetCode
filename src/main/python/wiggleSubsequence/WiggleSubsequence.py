class Solution:
    def wiggleMaxLength(self, nums: list[int]) -> int:
        up = [0] * len(nums)
        down = [0] * len(nums)
        up[0] = down[0] = 1
        for i in range(1, len(nums)):
            if nums[i] > nums[i - 1]:
                up[i] = down[i - 1] + 1
                down[i] = down[i - 1]
            elif nums[i] < nums[i - 1]:
                down[i] = up[i - 1] + 1
                up[i] = up[i - 1]
            else:
                up[i] = up[i - 1]
                down[i] = down[i - 1]
        return max(up[len(nums) - 1], down[len(nums) - 1])

    def test(self):
        tests = [
            [[1, 7, 4, 9, 2, 5], 6],
            [[1, 17, 5, 10, 13, 15, 10, 5, 16, 8], 7],
            [[1, 2, 3, 4, 5, 6, 7, 8, 9], 2],
        ]
        for test in tests:
            nums, expect_result = test
            result = self.wiggleMaxLength(nums)
            print(result)
            print(result == expect_result)


if __name__ == '__main__':
    Solution().test()
