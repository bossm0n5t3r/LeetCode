package excelSheetColumnNumber

class ExcelSheetColumnNumber {
    fun titleToNumber(columnTitle: String): Int {
        var result = 0
        var index = 1
        val map = letterToNumber()
        if (columnTitle.length == 1) return map[columnTitle]!!
        for (i in columnTitle.length - 1 downTo 0) {
            result += (index * map[columnTitle[i].toString()]!!)
            index *= 26
        }
        return result
    }

    private fun letterToNumber(): Map<String, Int> {
        val result = mutableMapOf<String, Int>()
        for (i in 1..26) {
            result[(i + 64).toChar().toString()] = i
        }
        return result
    }
}
