class Solution:
    def minDeletions(self, s: str) -> int:
        result = 0
        cnt_to_c = self.__get_cnt_to_char(s)
        max_key = max(cnt_to_c.keys())
        while max_key > 0:
            cnt = max_key
            max_key -= 1
            if cnt in cnt_to_c:
                target_chars = cnt_to_c[cnt]
                if len(target_chars) == 1:
                    continue
                while len(target_chars) > 1:
                    cur = target_chars.pop()
                    if cnt > 1:
                        tmp = cnt
                        while tmp > 1 and tmp in cnt_to_c:
                            tmp -= 1
                        if tmp not in cnt_to_c:
                            cnt_to_c[tmp] = []
                        cnt_to_c[tmp].append(cur)
                        result += (cnt - tmp)
                    else:
                        result += 1
        return result

    def __get_cnt_to_char(self, s):
        sorted_s = sorted(s)
        cnt_to_c = {}
        cur_c = sorted_s[0]
        cnt = 0
        for c in sorted_s:
            if c == cur_c:
                cnt += 1
            else:
                if cnt not in cnt_to_c:
                    cnt_to_c[cnt] = []
                cnt_to_c[cnt].append(cur_c)
                cur_c = c
                cnt = 1
        if cnt not in cnt_to_c:
            cnt_to_c[cnt] = []
        cnt_to_c[cnt].append(cur_c)
        return cnt_to_c

    def test(self):
        tests = [
            ["aab", 0],
            ["aaabbbcc", 2],
            ["ceabaacb", 2],
            ["bbcebab", 2],
            ["abcabc", 3]
        ]
        for test in tests:
            s, expect_result = test
            result = self.minDeletions(s)
            print(result)
            print(result == expect_result)


if __name__ == '__main__':
    Solution().test()
