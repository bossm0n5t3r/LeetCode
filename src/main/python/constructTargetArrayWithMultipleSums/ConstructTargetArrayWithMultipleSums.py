import heapq


class Solution:
    def isPossible(self, target: list[int]) -> bool:
        if len(target) == 1:
            return target[0] == 1
        heap = []
        for num in target:
            heapq.heappush(heap, -num)
        while heap:
            cur_max = -heapq.heappop(heap)
            if cur_max == 1:
                break
            if sum(heap) == -1:
                return True
            tmp = min(cur_max + sum(heap), cur_max % -sum(heap))
            if tmp >= 1:
                heapq.heappush(heap, -tmp)
            else:
                return False
        return -sum(heap) == len(heap)

    def test(self):
        tests = [
            [[9, 3, 5], True],
            [[1, 1, 1, 2], False],
            [[8, 5], True],
            [[1, 1000000000], True],
            [[2, 900000001], True],
        ]
        for test in tests:
            target, expect_result = test
            result = self.isPossible(target)
            print(result == expect_result)


if __name__ == "__main__":
    Solution().test()
