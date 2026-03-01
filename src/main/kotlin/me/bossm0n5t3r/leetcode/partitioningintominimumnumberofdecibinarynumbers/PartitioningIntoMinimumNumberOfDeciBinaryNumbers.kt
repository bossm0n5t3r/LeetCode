package me.bossm0n5t3r.leetcode.partitioningintominimumnumberofdecibinarynumbers

class PartitioningIntoMinimumNumberOfDeciBinaryNumbers {
    class Solution {
        fun minPartitions(n: String): Int = n.max() - '0'
    }
}
