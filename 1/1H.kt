import java.lang.Long.max
import java.lang.Long.min

fun main(args: Array<String>) {
    val a = readLine()!!.toLong()
    val b = readLine()!!.toLong()
    val n = readLine()!!.toLong()
    val m = readLine()!!.toLong()

    val maxA = (a + 1) * n + a
    val minA = (1 + a) * (n - 1) + 1

    val maxB = (b + 1) * m + b
    val minB = (1 + b) * (m - 1) + 1

    val totalMin = max(minA, minB)
    val totalMax = min(maxA, maxB)

    if (totalMax < totalMin) {
        print(-1)
    } else {
        print("$totalMin $totalMax")
    }
}
