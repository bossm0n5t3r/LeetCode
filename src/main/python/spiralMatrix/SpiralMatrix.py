class Solution:
    """
    https://leetcode.com/problems/spiral-matrix/discuss/20571/1-liner-in-Python-+-Ruby
    """

    def spiralOrder(self, matrix: list[list[int]]) -> list[int]:
        return matrix and [*matrix.pop(0)] + self.spiralOrder([*zip(*matrix)][::-1])

    def test(self):
        tests = [
            [[[1, 2, 3], [4, 5, 6], [7, 8, 9]], [1, 2, 3, 6, 9, 8, 7, 4, 5]],
            [
                [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12]],
                [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7],
            ],
        ]
        for test in tests:
            matrix, expect_result = test
            result = self.spiralOrder(matrix)
            print(result)
            print(result == expect_result)


if __name__ == "__main__":
    Solution().test()
