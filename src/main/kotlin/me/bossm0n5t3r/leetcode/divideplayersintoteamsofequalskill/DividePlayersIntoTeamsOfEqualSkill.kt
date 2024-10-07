package me.bossm0n5t3r.leetcode.divideplayersintoteamsofequalskill

class DividePlayersIntoTeamsOfEqualSkill {
    class Solution {
        fun dividePlayers(skill: IntArray): Long {
            val n = skill.size
            val sortedSkill = skill.map { it.toLong() }.sorted()
            var result = sortedSkill.first() * sortedSkill.last()
            if (n == 2) return result
            val totalSkill = sortedSkill.first() + sortedSkill.last()
            for (i in 1 until n / 2) {
                if (totalSkill != sortedSkill[i] + sortedSkill[n - 1 - i]) return -1
                result += sortedSkill[i] * sortedSkill[n - 1 - i]
            }
            return result
        }
    }
}
