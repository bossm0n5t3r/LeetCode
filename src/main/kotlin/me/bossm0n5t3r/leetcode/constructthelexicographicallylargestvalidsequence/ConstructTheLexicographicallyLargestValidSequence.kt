package me.bossm0n5t3r.leetcode.constructthelexicographicallylargestvalidsequence

class ConstructTheLexicographicallyLargestValidSequence {
    class Solution {
        fun constructDistancedSequence(targetNumber: Int): IntArray {
            // Initialize the result sequence with size 2*n - 1 filled with 0s
            val resultSequence = IntArray(targetNumber * 2 - 1)

            // Keep track of which numbers are already placed in the sequence
            val isNumberUsed = BooleanArray(targetNumber + 1)

            // Start recursive backtracking to construct the sequence
            findLexicographicallyLargestSequence(
                0,
                resultSequence,
                isNumberUsed,
                targetNumber,
            )

            return resultSequence
        }

        // Recursive function to generate the desired sequence
        private fun findLexicographicallyLargestSequence(
            currentIndex: Int,
            resultSequence: IntArray,
            isNumberUsed: BooleanArray,
            targetNumber: Int,
        ): Boolean {
            // If we have filled all positions, return true indicating success
            if (currentIndex == resultSequence.size) {
                return true
            }

            // If the current position is already filled, move to the next index
            if (resultSequence[currentIndex] != 0) {
                return findLexicographicallyLargestSequence(currentIndex + 1, resultSequence, isNumberUsed, targetNumber)
            }

            // Attempt to place numbers from targetNumber to 1 for a
            // lexicographically largest result
            for (numberToPlace in targetNumber downTo 1) {
                if (isNumberUsed[numberToPlace]) continue

                isNumberUsed[numberToPlace] = true
                resultSequence[currentIndex] = numberToPlace

                // If placing number 1, move to the next index directly
                if (numberToPlace == 1) {
                    if (findLexicographicallyLargestSequence(currentIndex + 1, resultSequence, isNumberUsed, targetNumber)) {
                        return true
                    }
                } else if (currentIndex + numberToPlace < resultSequence.size && resultSequence[currentIndex + numberToPlace] == 0) {
                    resultSequence[currentIndex + numberToPlace] = numberToPlace

                    if (findLexicographicallyLargestSequence(currentIndex + 1, resultSequence, isNumberUsed, targetNumber)) {
                        return true
                    }

                    // Undo the placement for backtracking
                    resultSequence[currentIndex + numberToPlace] = 0
                }

                // Undo current placement and mark the number as unused
                resultSequence[currentIndex] = 0
                isNumberUsed[numberToPlace] = false
            }

            return false
        }
    }
}
