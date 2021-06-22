fun main() {
    val numbers = readLine()!!.split(" ").map { it.toInt() }
    val n = numbers[0]
    val m = numbers[1]
    val k = numbers[2]

    val field = Array(n) { IntArray(m) }

    val shifts = listOf(
        -1 to -1,
        -1 to 0,
        -1 to 1,
        0 to -1,
        0 to 1,
        1 to -1,
        1 to 0,
        1 to 1
    )

    for (i in 0 until k) {
        val line = readLine()!!.split(" ").map { it.toInt() }
        val p = line[0]
        val q = line[1]
        field[p - 1][q - 1] = -1

        for ((verticalShift, horizontalShift) in shifts) {
            if ((p + verticalShift - 1) in 0 until n && (q + horizontalShift - 1) in 0 until m) {
                if (field[p + verticalShift - 1][q + horizontalShift - 1] != -1) {
                    field[p + verticalShift - 1][q + horizontalShift - 1]++
                }
            }
        }
    }

    for (line in field) {
        println(line.joinToString(" ").replace("-1", "*"))
    }
}
