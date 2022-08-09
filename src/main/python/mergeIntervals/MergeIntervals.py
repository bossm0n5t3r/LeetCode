class Solution:
    def merge(self, intervals: list[list[int]]) -> list[list[int]]:
        sorted_intevals = sorted(intervals, key=lambda x: x[0])
        result = []
        while sorted_intevals:
            interval = sorted_intevals.pop(0)
            if not result or result[-1][1] < interval[0]:
                result.append(interval)
            else:
                result[-1][1] = max(result[-1][1], interval[1])
        return result

    def test(self):
        tests = [
            [[[1, 3], [2, 6], [8, 10], [15, 18]], [[1, 6], [8, 10], [15, 18]]],
            [[[1, 4], [4, 5]], [[1, 5]]],
        ]
        for test in tests:
            intervals, expect_result = test
            result = self.merge(intervals)
            print(result)
            print(result == expect_result)


if __name__ == "__main__":
    Solution().test()
