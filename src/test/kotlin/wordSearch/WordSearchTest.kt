package wordSearch

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WordSearchTest {
    private val wordSearch = WordSearch()

    data class WordSearchTestData(
        val board: Array<CharArray>,
        val word: String,
        val result: Boolean
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as WordSearchTestData

            if (!board.contentDeepEquals(other.board)) return false
            if (word != other.word) return false
            if (result != other.result) return false

            return true
        }

        override fun hashCode(): Int {
            var result1 = board.contentDeepHashCode()
            result1 = 31 * result1 + word.hashCode()
            result1 = 31 * result1 + result.hashCode()
            return result1
        }
    }

    @Test
    fun exist() {
        val tests = listOf(
//            WordSearchTestData(
//                getBoard("[[\"A\",\"B\",\"C\",\"E\"],[\"S\",\"F\",\"C\",\"S\"],[\"A\",\"D\",\"E\",\"E\"]]"),
//                "ABCCED",
//                true
//            ),
//            WordSearchTestData(
//                getBoard("[[\"A\",\"B\",\"C\",\"E\"],[\"S\",\"F\",\"C\",\"S\"],[\"A\",\"D\",\"E\",\"E\"]]"),
//                "SEE",
//                true
//            ),
//            WordSearchTestData(
//                getBoard("[[\"A\",\"B\",\"C\",\"E\"],[\"S\",\"F\",\"C\",\"S\"],[\"A\",\"D\",\"E\",\"E\"]]"),
//                "ABCB",
//                false
//            ),
//            WordSearchTestData(
//                getBoard("[[\"a\",\"a\"]]"),
//                "aa",
//                true
//            ),
//            WordSearchTestData(
//                getBoard("[[\"a\",\"b\"]]"),
//                "aba",
//                false
//            ),
//            WordSearchTestData(
//                getBoard("[[\"C\",\"A\",\"A\"],[\"A\",\"A\",\"A\"],[\"B\",\"C\",\"D\"]]"),
//                "AAB",
//                true
//            ),
            WordSearchTestData(
                getBoard("[[\"A\",\"B\",\"C\",\"E\"],[\"S\",\"F\",\"E\",\"S\"],[\"A\",\"D\",\"E\",\"E\"]]"),
                "ABCESEEEFS",
                true
            ),
        )
        tests.forEach { test ->
            println(wordSearch.exist(test.board, test.word))
//            assertThat(wordSearch.exist(test.board, test.word)).isEqualTo(test.result)
        }
    }

    private fun getBoard(rawData: String): Array<CharArray> {
        return rawData
            .substring(2, rawData.length - 2)
            .split("],[")
            .map { row ->
                row
                    .split(",")
                    .map { e ->
                        e[1]
                    }
                    .toCharArray()
            }
            .toTypedArray()
    }
}
