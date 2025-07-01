package me.bossm0n5t3r.leetcode.findtheoriginaltypedstringi

class FindTheOriginalTypedStringI {
    class Solution {
        fun possibleStringCount(word: String): Int {
            var result = 1
            var count = 1
            var index = 1
            while (index < word.length) {
                if (word[index - 1] != word[index]) {
                    result += (count - 1)
                    count = 1
                    index++
                    continue
                }
                count++
                index++
            }
            if (count > 1) {
                result += (count - 1)
            }
            return result
        }
    }
}
