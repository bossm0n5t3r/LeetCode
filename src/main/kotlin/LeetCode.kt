import java.io.File
import java.nio.file.Paths
import kotlin.io.path.exists

class LeetCode {
    private val projectDirAbsolutePath = Paths.get("").toAbsolutePath().toString()
    private val problemPath = Paths.get(projectDirAbsolutePath, "src/main/kotlin/me/bossm0n5t3r/leetcode")

    private lateinit var name: String
    private lateinit var url: String
    private val sampleCode = mutableListOf<String>()

    fun run() {
        readProblem()
        createFiles()
        // TODO Create test files
    }

    private fun readProblem() {
        print("Enter problem name: ")
        var tmpName = readlnOrNull()
        while (tmpName.isNullOrBlank()) {
            println("Problem name cannot be blank")
            print("Enter problem name: ")
            tmpName = readlnOrNull()
        }
        name = tmpName

        print("Enter problem url: ")
        var tmpUrl = readlnOrNull()
        while (tmpUrl.isNullOrBlank()) {
            println("Problem url cannot be blank")
            print("Enter problem url: ")
            tmpUrl = readlnOrNull()
        }
        url = tmpUrl

        print("Enter sample code: ")
        while (true) {
            val line = readln()
            if (line == "") {
                break
            }
            sampleCode.add(line)
        }
    }

    private fun createFiles() {
        val camelCaseProblemName = this.name.toCamelCase()
        val newProblemPath = Paths.get(problemPath.toString(), camelCaseProblemName)
        try {
            if (newProblemPath.exists()) throw Exception("Directory already exists")

            newProblemPath.toFile().mkdirs()
            println("Created directory: ${newProblemPath.toAbsolutePath()}\n")

            // Create README.md
            File(newProblemPath.toString(), "README.md").writeText(
                """
                # $name
                
                - [$url]($url)
                
                """.trimIndent(),
            )

            // Create Problem
            val pascalCaseProblemName = this.name.toPascalCase()
            val sampleCodeString = this.sampleCode.joinToString("\n") {
                "    ${it.ifBlank { "${it}TODO()" }}"
            }
            File(newProblemPath.toString(), "$pascalCaseProblemName.kt").writeText(
                """
package me.bossm0n5t3r.leetcode.$camelCaseProblemName

class $pascalCaseProblemName {
$sampleCodeString
}

                """.trimIndent(),
            )
        } catch (e: Exception) {
            println("Error: ${e.message}")
        }
    }

    private fun String.toCamelCase(): String {
        return this
            .substringAfter(". ")
            .replace("II", "2")
            .split(" ")
            .mapIndexed { index, s ->
                if (index == 0) {
                    s.lowercase()
                } else {
                    s.lowercase().replaceFirstChar { it.uppercase() }
                }
            }
            .joinToString("")
    }

    private fun String.toPascalCase(): String {
        return this
            .substringAfter(". ")
            .replace("II", "2")
            .split(" ")
            .joinToString("") { s ->
                s.lowercase().replaceFirstChar { it.uppercase() }
            }
    }
}

fun main() {
    LeetCode().run()
}
