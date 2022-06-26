class Solution:
    def checkPossibility(self, nums: list[int]) -> bool:
        break_idx = -1
        for i in range(len(nums) - 1):
            cur = nums[i]
            next_num = nums[i + 1]
            if cur > next_num:
                break_idx = i
                break
        front = nums[:break_idx + 1]
        back = nums[break_idx + 1:]
        if not self.__valid(front) or not self.__valid(back):
            return False
        if len(front) <= 1 or len(back) <= 1:
            return True
        if front[-1] <= back[1] or front[-2] <= back[0]:
            return True
        return False

    def __valid(self, nums):
        if len(nums) == 0:
            return True
        break_idx = -1
        for i in range(len(nums) - 1):
            cur = nums[i]
            next_num = nums[i + 1]
            if cur > next_num:
                break_idx = i
                break
        return break_idx == -1

    def test(self):
        tests = [
            [[4, 2, 3], True],
            [[1, 2, 1], True],
            [[4, 2, 1], False],
            [[3, 4, 2, 3], False],
            [[5, 7, 1, 8], True],
            [[-1, 4, 2, 3], True],
        ]
        for test in tests:
            nums, expect_result = test
            result = self.checkPossibility(nums)
            print(result == expect_result)


if __name__ == '__main__':
    Solution().test()
