class Solution:
    def kthSmallest(self, matrix: list[list[int]], k: int) -> int:
        n = len(matrix)
        low = matrix[0][0]
        high = matrix[-1][-1]
        while low < high:
            mid = low + (high - low) // 2
            count = 0
            c = n - 1
            for r in range(n):
                while c >= 0 and matrix[r][c] > mid:
                    c -= 1
                count += c + 1
            if count < k:
                low = mid + 1
            else:
                high = mid
        return low

    def test(self):
        tests = [
            [[[1, 5, 9], [10, 11, 13], [12, 13, 15]], 8, 13],
            [[[-5]], 1, -5],
        ]
        for test in tests:
            matrix, k, expect_result = test
            result = self.kthSmallest(matrix, k)
            print(result)
            print(result == expect_result)


if __name__ == "__main__":
    Solution().test()
