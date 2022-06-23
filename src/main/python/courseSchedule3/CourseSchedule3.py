import heapq


class Solution:
    def scheduleCourse(self, courses: list[list[int]]) -> int:
        sorted_courses = sorted(courses, key=lambda x: x[1])
        heap = []
        time = 0
        for course in sorted_courses:
            duration, last_day = course
            time += duration
            heapq.heappush(heap, -duration)
            if time > last_day:
                time -= -heapq.heappop(heap)
        return len(heap)

    def test(self):
        tests = [
            [[[100, 200], [200, 1300], [1000, 1250], [2000, 3200]], 3],
            [[[1, 2]], 1],
            [[[3, 2], [4, 3]], 0],
        ]
        for test in tests:
            courses, expect_result = test
            result = self.scheduleCourse(courses)
            print(result)
            print(result == expect_result)


if __name__ == "__main__":
    Solution().test()
