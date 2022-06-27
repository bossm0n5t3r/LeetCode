class Solution:
    def minPartitions(self, n: str) -> int:
        return int(max(n))

    def test(self):
        tests = [
            ["32", 3],
            ["82734", 8],
            ["27346209830709182346", 9],
        ]
        for test in tests:
            n, expect_result = test
            result = self.minPartitions(n)
            print(result)
            print(result == expect_result)


if __name__ == '__main__':
    Solution().test()
