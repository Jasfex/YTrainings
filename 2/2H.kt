fun main() {
    val numbers = readLine()!!.split(" ").map { it.toLongOrNull() }.filterNotNull()

    val sorted = numbers.sorted()

    if (sorted.size >= 5) {
        val max3 = sorted[sorted.size - 1] * sorted[sorted.size - 2] * sorted[sorted.size - 3]
        val min2max = sorted[0] * sorted[1] * sorted[sorted.size - 1]
        if (max3 > min2max) {
            println("${sorted[sorted.size - 1]} ${sorted[sorted.size - 2]} ${sorted[sorted.size - 3]}")
        } else {
            println("${sorted[sorted.size - 1]} ${sorted[0]} ${sorted[1]}")
        }
        return
    } else {
        var bestProduct = Long.MIN_VALUE
        var bestList = emptyList<Long>()
        for (i in sorted.indices) {
            for (j in sorted.indices) {
                if (i == j) continue
                for (k in sorted.indices) {
                    if (i == k || j == k) continue

                    val product = sorted[i] * sorted[j] * sorted[k]
                    if (product > bestProduct) {
                        bestProduct = product
                        bestList = listOf(sorted[i], sorted[j], sorted[k])
                    }
                }
            }
        }
        println(bestList.joinToString(" "))
    }
}
