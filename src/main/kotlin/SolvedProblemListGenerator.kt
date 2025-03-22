import java.io.File

object SolvedProblemListGenerator {
    fun generate() {
        readAllREADMEFiles()
            .map { it.toSolvedProblem() }
            .sortedBy { it.number }
            .toREADME()
            .writeToREADME()
    }

    private fun readAllREADMEFiles(): List<File> =
        File("src/main/kotlin/me/bossm0n5t3r/leetcode")
            .walk()
            .filter { it.isFile && it.name.contains("README") }
            .toList()

    private data class SolvedProblem(
        val number: Int,
        val title: String,
        val url: String,
        val fileName: String,
    )

    private fun File.toSolvedProblem(): SolvedProblem {
        val titleLine = readLines().first()
        val number = titleLine.substringAfter("# ").substringBefore(". ").toInt()
        val title = titleLine.substringAfter(". ")
        val urlLine =
            readLines().find { it.contains("https://leetcode.com/problems/") }
                ?: error("Not found URL in $this")
        val url = urlLine.substringAfter("- [").substringBefore("](")
        return SolvedProblem(number, title, url, this.name)
    }

    private fun List<SolvedProblem>.toREADME(): String {
        val readme = StringBuilder()
        readme.append("# LeetCode\n\n")
        readme.append("- LeetCode solutions in `Kotlin`\n\n")
        readme.append("## Solved Problems\n\n")
        readme.append("| # | Title | Solution |\n")
        readme.append("|---|-------|----------|\n")
        forEach { readme.append(it.toMarkdownRow()).append("\n") }
        return readme.toString()
    }

    private fun SolvedProblem.toMarkdownRow(): String =
        "| $number | [$title]($url) | [Solution](src/main/kotlin/me/bossm0n5t3r/leetcode/$fileName) |"

    private fun String.writeToREADME() {
        File("README.md").writeText(this)
    }
}
