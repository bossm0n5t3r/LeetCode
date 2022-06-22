import heapq


class Solution:
    def furthestBuilding(self, heights: list[int], bricks: int, ladders: int) -> int:
        heap = []
        for idx in range(len(heights) - 1):
            diff = heights[idx + 1] - heights[idx]
            if diff > 0:
                heapq.heappush(heap, diff)
            if len(heap) > ladders:
                bricks -= heapq.heappop(heap)
            if bricks < 0:
                return idx
        return len(heights) - 1

    def test(self):
        tests = [
            [[4, 2, 7, 6, 9, 14, 12], 5, 1, 4],
            [[4, 12, 2, 7, 3, 18, 20, 3, 19], 10, 2, 7],
            [[14, 3, 19, 3], 17, 0, 3],
            [[1, 5, 1, 2, 3, 4, 10000], 4, 1, 5],
        ]
        for test in tests:
            heights, bricks, ladders, test_result = test
            result = self.furthestBuilding(heights, bricks, ladders)
            print(result)
            print(result == test_result)


if __name__ == "__main__":
    Solution().test()
