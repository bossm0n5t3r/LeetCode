class Solution:
    def minMoves2(self, nums: list[int]) -> int:
        sorted_nums = sorted(nums)
        median = sorted_nums[len(sorted_nums) // 2]
        result = 0
        for num in nums:
            result += abs(num - median)
        return result

    def test(self):
        tests = [
            [[1, 2, 3], 2],
            [[1, 10, 2, 9], 16],
        ]
        for test in tests:
            nums, expect_result = test
            result = self.minMoves2(nums)
            print(result)
            print(result == expect_result)


if __name__ == '__main__':
    Solution().test()
