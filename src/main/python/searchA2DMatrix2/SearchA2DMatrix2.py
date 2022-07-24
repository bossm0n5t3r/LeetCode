class Solution:
    def searchMatrix(self, matrix: list[list[int]], target: int) -> bool:
        for row in matrix:
            if row[0] > target:
                return False
            idx = 0
            while idx < len(row):
                if target == row[idx]:
                    return True
                if target < row[idx]:
                    break
                idx += 1
        return False

    def test(self):
        tests = [
            [
                [
                    [1, 4, 7, 11, 15],
                    [2, 5, 8, 12, 19],
                    [3, 6, 9, 16, 22],
                    [10, 13, 14, 17, 24],
                    [18, 21, 23, 26, 30],
                ],
                5,
                True,
            ],
            [
                [
                    [1, 4, 7, 11, 15],
                    [2, 5, 8, 12, 19],
                    [3, 6, 9, 16, 22],
                    [10, 13, 14, 17, 24],
                    [18, 21, 23, 26, 30],
                ],
                20,
                False,
            ],
        ]
        for test in tests:
            matrix, target, expect_result = test
            result = self.searchMatrix(matrix, target)
            print(result == expect_result)


if __name__ == "__main__":
    Solution().test()
