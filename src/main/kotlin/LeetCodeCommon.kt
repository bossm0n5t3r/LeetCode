import java.nio.file.Path
import java.nio.file.Paths

data class LeetCodeProblem(
    val name: String,
    val url: String,
    val sampleCodes: List<String>,
    val methodParametersAndResultAsString: String,
    val exampleTestcases: String,
)

data class Problem(
    val name: String,
    val url: String,
    val sampleCodes: List<String>,
    val methodParametersAndResultAsString: String,
    val exampleTestcases: String,
    val filePath: String,
)

private val projectDirAbsolutePath = Paths.get("").toAbsolutePath().toString()
val problemPath: Path = Paths.get(projectDirAbsolutePath, "src/main/kotlin/me/bossm0n5t3r/leetcode")
val testPath: Path = Paths.get(projectDirAbsolutePath, "src/test/kotlin/me/bossm0n5t3r/leetcode")
