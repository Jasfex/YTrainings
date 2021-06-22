fun computeOdd(n: Int, seq: List<Int>): Pair<Int, List<Int>> {
    var index = n / 2
    while (index < n) {

        var isEqual = true
        for (step in 0 until n - index) {
            val left = seq[index - step]
            val right = seq[index + step]
            if (left != right) {
                isEqual = false
            }
        }

        if (isEqual) {
            val remain = n - (2 * (n - (index + 1)) + 1)
            return remain to (remain - 1 downTo 0).map { seq[it] }
        }

        ++index
    }

    return Int.MAX_VALUE to emptyList()
}

fun computeEven(n: Int, seq: List<Int>): Pair<Int, List<Int>> {
    var index = (n - 1) / 2 + 1
    while (index < n) {

        var isEqual = true
        for (step in 0 until n - index) {
            val left = seq[index - 1 - step]
            val right = seq[index + step]
            if (left != right) {
                isEqual = false
            }
        }

        if (isEqual) {
            val remain = n - 2 * (n - index)
            return remain to (remain - 1 downTo 0).map { seq[it] }
        }

        ++index
    }

    return Int.MAX_VALUE to emptyList()
}

fun main() {
    val n = readLine()!!.toInt()
    val seq = readLine()!!.split(" ").map { it.toIntOrNull() }.filterNotNull()

    if (n == 1) {
        print(0)
        return
    }

    val oddAnswer = computeOdd(n, seq)
    val evenAnswer = computeEven(n, seq)

    if (oddAnswer.first < evenAnswer.first) {
        println(oddAnswer.first)
        println(oddAnswer.second.joinToString(" "))
    } else {
        println(evenAnswer.first)
        println(evenAnswer.second.joinToString(" "))
    }
}
