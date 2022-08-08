class Solution:
    def arithmeticTriplets(self, nums: list[int], diff: int) -> int:
        seen = set()
        result = 0
        for num in nums:
            if num - diff in seen and num - diff * 2 in seen:
                result += 1
            seen.add(num)
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
