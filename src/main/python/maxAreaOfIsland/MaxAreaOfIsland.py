class Solution:
    def maxAreaOfIsland(self, grid: list[list[int]]) -> int:
        m, n = len(grid), len(grid[0])
        visited = [[False] * n for _ in range(m)]
        max_area = 0
        for r in range(m):
            for c in range(n):
                if not visited[r][c] and grid[r][c] == 1:
                    tmp_area = self.__bfs(m, n, grid, visited, r, c)
                    if tmp_area > max_area:
                        max_area = tmp_area
        return max_area

    def __bfs(self, m, n, grid, visited, r, c):
        dr = [0, 0, 1, -1]
        dc = [1, -1, 0, 0]
        queue = []
        queue.append((r, c))
        result = 0
        while queue:
            cur_r, cur_c = queue.pop(0)
            visited[cur_r][cur_c] = True
            result += 1
            for i in range(4):
                nr = cur_r + dr[i]
                nc = cur_c + dc[i]
                if (
                    0 <= nr < m
                    and 0 <= nc < n
                    and not visited[nr][nc]
                    and grid[nr][nc] == 1
                ):
                    queue.append((nr, nc))
                    visited[nr][nc] = True
        return result

    def test(self):
        tests = [
            [
                [
                    [0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0],
                    [0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0],
                    [0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0],
                    [0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0],
                    [0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0],
                    [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0],
                    [0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0],
                    [0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0],
                ],
                6,
            ],
            [[[0, 0, 0, 0, 0, 0, 0, 0]], 0],
        ]
        for test in tests:
            grid, expect_result = test
            result = self.maxAreaOfIsland(grid)
            print(result)
            print(result == expect_result)


if __name__ == "__main__":
    Solution().test()
