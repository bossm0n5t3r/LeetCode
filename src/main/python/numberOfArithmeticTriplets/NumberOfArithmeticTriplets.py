class Solution:
    def arithmeticTriplets(self, nums: list[int], diff: int) -> int:
        n = len(nums)
        result = 0
        for i in range(len(nums) - 2):
            start = nums[i]
            j = i + 1
            while j < n and start + diff > nums[j]:
                j += 1
            if j < n and start + diff == nums[j]:
                start = nums[j]
                k = j + 1
                while k < n and start + diff > nums[k]:
                    k += 1
                if k < n and start + diff == nums[k]:
                    result += 1
        return result

    def test(self):
        tests = [
            [[0, 1, 4, 6, 7, 10], 3, 2],
            [[4, 5, 6, 7, 8, 9], 2, 2],
        ]
        for test in tests:
            nums, diff, expect_result = test
            result = self.arithmeticTriplets(nums, diff)
            print(result)
            print(result == expect_result)


if __name__ == "__main__":
    Solution().test()
