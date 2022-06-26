class Solution:
    def solveNQueens(self, n: int) -> list[list[str]]:
        board = [["."] * n for _ in range(n)]
        result = []
        self.dfs(0, board, result)
        return result

    def dfs(self, row, board, result):
        if row == len(board):
            result.append(["".join(row) for row in board])
            return
        for col in range(len(board)):
            if self.is_safe(row, col, board):
                board[row][col] = "Q"
                self.dfs(row + 1, board, result)
                board[row][col] = "."

    def is_safe(self, row, col, board):
        n = len(board)
        for i in range(n):
            if board[i][col] == "Q":
                return False
            if row >= i and col + i < n and board[row - i][col + i] == "Q":
                return False
            if row >= i and col - i >= 0 and board[row - i][col - i] == "Q":
                return False
        return True

    def test(self):
        tests = [
            [4, [[".Q..", "...Q", "Q...", "..Q."], ["..Q.", "Q...", "...Q", ".Q.."]]],
            [1, [["Q"]]],
        ]
        for test in tests:
            n, expect_result = test
            result = self.solveNQueens(n)
            print(result)
            print(result == expect_result)


if __name__ == "__main__":
    Solution().test()
