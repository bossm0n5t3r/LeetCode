import sys


class Solution:
    def longestConsecutive(self, nums: list[int]) -> int:
        if len(nums) == 0:
            return 0
        MAX = sys.maxsize
        records = {}
        deep_dive = {}
        for num in nums:
            if num not in deep_dive:
                deep_dive[num] = MAX
                records[num] = 1
                tmp = num - 1
                while tmp in deep_dive and deep_dive[tmp] != MAX:
                    tmp = deep_dive[tmp]
                if tmp in deep_dive:
                    records[num] += records[tmp]
                    deep_dive[tmp] = num
                tmp = num + 1
                while tmp in deep_dive and deep_dive[tmp] != MAX:
                    tmp = deep_dive[tmp]
                if tmp in deep_dive:
                    records[num] += records[tmp]
                    deep_dive[tmp] = num
        return max(records.values())

    def test(self):
        tests = [
            [[100, 4, 200, 1, 3, 2], 4],
            [[0, 3, 7, 2, 5, 8, 4, 6, 0, 1], 9],
        ]
        for test in tests:
            nums, expect_result = test
            result = self.longestConsecutive(nums)
            print(result)
            print(result == expect_result)


if __name__ == '__main__':
    Solution().test()
