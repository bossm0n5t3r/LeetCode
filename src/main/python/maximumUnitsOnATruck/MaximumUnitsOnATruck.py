class Solution:
    def maximumUnits(self, box_types: list[list[int]], truck_size: int) -> int:
        sorted_box_types = sorted(box_types, key=lambda x: -x[1])
        result = 0
        for box, units in sorted_box_types:
            if truck_size > box:
                truck_size -= box
                result += box * units
            else:
                result += truck_size * units
                return result
        return result

    def test(self):
        tests = [
            [[[1, 3], [2, 2], [3, 1]], 4, 8],
            [[[5, 10], [2, 5], [4, 7], [3, 9]], 10, 91],
        ]
        for test in tests:
            box_types, truck_size, expect_result = test
            result = self.maximumUnits(box_types, truck_size)
            print(result)
            print(result == expect_result)


if __name__ == '__main__':
    Solution().test()
