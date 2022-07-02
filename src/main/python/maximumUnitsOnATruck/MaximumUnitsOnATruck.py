class Solution:
    def maximumUnits(self, box_types: list[list[int]], truck_size: int) -> int:
        sorted_box_types = sorted(box_types, key=lambda x: -x[1])
        result = 0
        box_types_idx = 0
        while truck_size > 0 and box_types_idx < len(box_types):
            num_of_boxes, num_of_units_per_box = sorted_box_types[box_types_idx]
            while num_of_boxes > 0 and truck_size > 0:
                result += num_of_units_per_box
                num_of_boxes -= 1
                truck_size -= 1
            if num_of_boxes > 0:
                break
            box_types_idx += 1
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
