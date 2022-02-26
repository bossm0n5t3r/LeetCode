package kthSmallestElementInASortedMatrix

class KthSmallestElementInASortedMatrix {
    fun kthSmallest(matrix: Array<IntArray>, k: Int): Int {
        return matrix.flatMap { it.toList() }.sorted()[k - 1]
    }
}
