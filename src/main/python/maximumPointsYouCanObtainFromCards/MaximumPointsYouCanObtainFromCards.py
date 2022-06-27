class Solution:
    def maxScore(self, cardPoints: list[int], k: int) -> int:
        if len(cardPoints) == k:
            return sum(cardPoints)
        remainder = len(cardPoints) - k
        tmp = sum(cardPoints[:remainder])
        min_value = tmp
        for i in range(remainder, len(cardPoints)):
            tmp += (cardPoints[i] - cardPoints[i - remainder])
            if min_value > tmp:
                min_value = tmp
        return sum(cardPoints) - min_value

    def test(self):
        tests = [
            [[1, 2, 3, 4, 5, 6, 1], 3, 12],
            [[2, 2, 2], 2, 4],
            [[9, 7, 7, 9, 7, 7, 9], 7, 55],
        ]
        for test in tests:
            cardPoints, k, expect_result = test
            result = self.maxScore(cardPoints, k)
            print(result)
            print(result == expect_result)


if __name__ == '__main__':
    Solution().test()
