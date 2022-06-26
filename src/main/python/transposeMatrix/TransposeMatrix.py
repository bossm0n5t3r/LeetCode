class Solution:
    def transpose(self, matrix: list[list[int]]) -> list[list[int]]:
        return [list(row) for row in zip(*matrix)]

    def test(self):
        tests = [
            [[[1, 2, 3], [4, 5, 6], [7, 8, 9]], [[1, 4, 7], [2, 5, 8], [3, 6, 9]]],
            [[[1, 2, 3], [4, 5, 6]], [[1, 4], [2, 5], [3, 6]]],
        ]
        for test in tests:
            matrix, expect_result = test
            result = self.transpose(matrix)
            print(result)
            print(result == expect_result)


if __name__ == "__main__":
    Solution().test()
