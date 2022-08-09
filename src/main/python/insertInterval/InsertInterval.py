class Solution:
    def insert(self, intervals, newInterval):
        s, e = newInterval
        left, right = [], []
        for interval in intervals:
            if interval[1] < s:
                left += (interval,)
            elif interval[0] > e:
                right += (interval,)
            else:
                s = min(s, interval[0])
                e = max(e, interval[1])
        return left + [[s, e]] + right

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
