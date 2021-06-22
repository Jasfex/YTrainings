fun main() {
    val n = readLine()!!.toInt()

    val answers = mutableSetOf<Pair<Int, Int>>()

    for (i in 0 until n) {
        val line = readLine()!!.split(" ").map { it.toInt() }
        if (line[0] < 0 || line[1] < 0) continue
        if (line[0] + line[1] + 1 == n) {
            answers.add(line[0] to line[1])
        }
    }

    print(answers.size)
}
