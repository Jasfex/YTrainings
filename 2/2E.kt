fun List<Int>.getMax(): Int {
    var bestValue: Int = this[0]
    forEach {
        if (it > bestValue) {
            bestValue = it
        }
    }
    return bestValue
}

fun main() {
    var n = readLine()!!.toInt()
    val results = readLine()!!.split(" ").map { it.toInt() }

    val bestResult = results.getMax()
    val bestResultIndex = results.indexOfFirst { it == bestResult }

    var bestVasilyResult: Int? = null

    for (index in bestResultIndex + 1 until results.size - 1) {
        val result = results[index]
        if (result % 10 == 5 && results[index] > results[index+1] && (bestVasilyResult == null || bestVasilyResult < result)) {
            bestVasilyResult = result
        }
    }

    if (bestVasilyResult == null) {
        print(0)
        return
    }

    var place = 1
    for (result in results) {
        if (result > bestVasilyResult) {
            place++
        }
    }
    print(place)

}
