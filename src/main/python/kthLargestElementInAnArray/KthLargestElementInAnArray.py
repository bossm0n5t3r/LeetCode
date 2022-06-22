import heapq


class Solution:
    def findKthLargest(self, nums: list[int], k: int) -> int:
        heap = []
        for num in nums:
            heapq.heappush(heap, -num)
        result = 0
        while k > 0:
            result = heapq.heappop(heap)
            k -= 1
        return -result

    def test(self):
        tests = [
            [[3, 2, 1, 5, 6, 4], 2, 5],
            [[3, 2, 3, 1, 2, 4, 5, 5, 6], 4, 4],
        ]
        for test in tests:
            nums, k, test_result = test
            result = self.findKthLargest(nums, k)
            print(result)
            print(result == test_result)


if __name__ == "__main__":
    Solution().test()
