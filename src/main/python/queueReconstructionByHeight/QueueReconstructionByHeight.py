class Solution:
    def reconstructQueue(self, people: list[list[int]]) -> list[list[int]]:
        people_with_height = sorted(people, key=lambda x: (-x[0], x[1]))
        res = []
        for person in people_with_height:
            res.insert(person[1], person)
        return res

    def test(self):
        tests = [
            [
                [[7, 0], [4, 4], [7, 1], [5, 0], [6, 1], [5, 2]],
                [[5, 0], [7, 0], [5, 2], [6, 1], [4, 4], [7, 1]]
            ],
            [
                [[6, 0], [5, 0], [4, 0], [3, 2], [2, 2], [1, 4]],
                [[4, 0], [5, 0], [2, 2], [3, 2], [1, 4], [6, 0]]
            ],
        ]
        for test in tests:
            people, expect_result = test
            result = self.reconstructQueue(people)
            print(result)
            print(result == expect_result)


if __name__ == '__main__':
    Solution().test()
