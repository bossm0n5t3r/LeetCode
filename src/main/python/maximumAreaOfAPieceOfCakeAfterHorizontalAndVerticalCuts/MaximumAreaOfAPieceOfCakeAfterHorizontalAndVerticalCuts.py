class Solution:
    def maxArea(self, h: int, w: int, horizontal_cuts: list[int], vertical_cuts: list[int]) -> int:
        horizontal_cuts = horizontal_cuts + [0, h]
        vertical_cuts = vertical_cuts + [0, w]

        sorted_horizontal_cuts = sorted(horizontal_cuts)
        rows = [sorted_horizontal_cuts[i] - sorted_horizontal_cuts[i - 1] for i in range(1, len(horizontal_cuts))]

        sorted_vertical_cuts = sorted(vertical_cuts)
        cols = [sorted_vertical_cuts[i] - sorted_vertical_cuts[i - 1] for i in range(1, len(vertical_cuts))]

        return (max(rows) * max(cols)) % (10 ** 9 + 7)

    def test(self):
        tests = [
            [5, 4, [1, 2, 4], [1, 3], 4],
            [5, 4, [3, 1], [1], 6],
            [5, 4, [3], [3], 9],
            [1000000000, 1000000000, [2], [2], 81]
        ]
        for test in tests:
            h, w, horizontal_cuts, vertical_cuts, expect_result = test
            result = self.maxArea(h, w, horizontal_cuts, vertical_cuts)
            print(result)
            print(result == expect_result)


if __name__ == '__main__':
    Solution().test()
