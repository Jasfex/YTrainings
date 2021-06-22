import kotlin.collections.ArrayDeque

fun main() {
    val n = readLine()!!.toInt()

    val coords = mutableMapOf<Int, ArrayDeque<Int>>()

    for (i in 0 until n) {
        val line = readLine()!!.split(" ").map { it.toInt() }
        val x = line[0]
        val y = line[1]

        if (!coords.contains(x)) {
            coords[x] = ArrayDeque<Int>()
        }
        coords[x]!!.add(y)
    }

    print(coords.size)
}
