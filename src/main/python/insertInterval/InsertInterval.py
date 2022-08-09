class Solution:
    def insert(self, intervals, newInterval):
        sorted_intevals = sorted(intervals + [newInterval], key=lambda x: x[0])
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
            [[[1, 3], [6, 9]], [2, 5], [[1, 5], [6, 9]]],
            [
                [[1, 2], [3, 5], [6, 7], [8, 10], [12, 16]],
                [4, 8],
                [[1, 2], [3, 10], [12, 16]],
            ],
        ]
        for test in tests:
            intervals, newInterval, expect_result = test
            result = self.insert(intervals, newInterval)
            print(result)
            print(result == expect_result)


if __name__ == "__main__":
    Solution().test()
