import java.lang.Long.max

fun main(args: Array<String>) {
    val input = readLine()!!.split(" ").map { it.toLong() }

    val w1 = input[0]
    val h1 = input[1]
    val w2 = input[2]
    val h2 = input[3]

    var bestTable: Pair<Long, Long> = Long.MAX_VALUE to Long.MAX_VALUE
    var bestSquare: Long = Long.MAX_VALUE

    var w = w1 + w2
    var h = max(h1, h2)
    if (w * h < bestSquare) {
        bestSquare = w * h
        bestTable = w to h
    }

    w = w1 + h2
    h = max(h1, w2)
    if (w * h < bestSquare) {
        bestSquare = w * h
        bestTable = w to h
    }

    w = h1 + w2
    h = max(w1, h2)
    if (w * h < bestSquare) {
        bestSquare = w * h
        bestTable = w to h
    }

    w = h1 + h2
    h = max(w1, w2)
    if (w * h < bestSquare) {
        bestSquare = w * h
        bestTable = w to h
    }

    print("${bestTable.first} ${bestTable.second}")
}
