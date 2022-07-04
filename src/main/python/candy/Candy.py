class Solution:
    def candy(self, ratings: list[int]) -> int:
        n = len(ratings)
        left2right = [1] * n
        right2left = [1] * n
        for i in range(1, n):
            if ratings[i - 1] >= ratings[i]:
                left2right[i] = 1
            else:
                left2right[i] = left2right[i - 1] + 1
        for i in range(n - 2, -1, -1):
            if ratings[i] <= ratings[i + 1]:
                right2left[i] = 1
            else:
                right2left[i] = right2left[i + 1] + 1
        return sum([max(a, b) for a, b in zip(left2right, right2left)])

    def test(self):
        tests = [
            [[1, 0, 2], 5],
            [[1, 2, 2], 4],
            [[1, 3, 2, 2, 1], 7],
            [[1, 2, 87, 87, 87, 2, 1], 13]
        ]
        for test in tests:
            ratings, expect_result = test
            result = self.candy(ratings)
            print(result)
            print(result == expect_result)


if __name__ == '__main__':
    Solution().test()
