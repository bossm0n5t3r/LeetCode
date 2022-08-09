class Solution:
    def spiralOrder(self, matrix: list[list[int]]) -> list[int]:
        m, n = len(matrix), len(matrix[0])
        given = [item for row in matrix for item in row]
        visited = [[False] * n for _ in range(m)]
        result = []
        idx = 1
        # direction
        # 동, 서, 남, 북 = 0, 1, 2, 3
        r, c, direction = 0, 0, 0
        while idx <= m * n:
            result.append(given[r * n + c])
            visited[r][c] = True
            if idx == m * n:
                break
            idx += 1
            if direction == 0 and (c == n - 1 or visited[r][c + 1]):
                r, direction = r + 1, 2
            elif direction == 2 and (r == m - 1 or visited[r + 1][c]):
                c, direction = c - 1, 1
            elif direction == 1 and (c == 0 or visited[r][c - 1]):
                r, direction = r - 1, 3
            elif direction == 3 and (r == 0 or visited[r - 1][c]):
                c, direction = c + 1, 0
            else:
                if direction == 0:
                    c += 1
                elif direction == 1:
                    c -= 1
                elif direction == 2:
                    r += 1
                elif direction == 3:
                    r -= 1
        return result

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
