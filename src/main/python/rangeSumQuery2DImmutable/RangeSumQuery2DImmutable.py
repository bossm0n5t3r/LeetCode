class NumMatrix:
    def __init__(self, matrix: list[list[int]]):
        m = len(matrix)
        n = len(matrix[0])
        self.dp = [[0] * (n + 1) for _ in range(m + 1)]
        for r in range(1, m + 1):
            for c in range(1, n + 1):
                self.dp[r][c] = (
                    matrix[r - 1][c - 1]
                    + self.dp[r - 1][c]
                    + self.dp[r][c - 1]
                    - self.dp[r - 1][c - 1]
                )

    def sumRegion(self, row1: int, col1: int, row2: int, col2: int) -> int:
        return (
            self.dp[row2 + 1][col2 + 1]
            - self.dp[row1][col2 + 1]
            - self.dp[row2 + 1][col1]
            + self.dp[row1][col1]
        )


if __name__ == "__main__":
    num_matrix = NumMatrix(
        [
            [3, 0, 1, 4, 2],
            [5, 6, 3, 2, 1],
            [1, 2, 0, 1, 5],
            [4, 1, 0, 1, 7],
            [1, 0, 3, 0, 5],
        ]
    )
    first = num_matrix.sumRegion(2, 1, 4, 3)
    print(first)
    second = num_matrix.sumRegion(1, 1, 2, 2)
    print(second)
    third = num_matrix.sumRegion(1, 2, 2, 4)
    print(third)
