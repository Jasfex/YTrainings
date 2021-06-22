import kotlin.math.abs
import kotlin.math.min
import kotlin.math.max

fun main() {
    val n = readLine()!!.toInt()
    var f = readLine()!!.toFloat()

    var start = 30.0f
    var finish = 4000.0f

    for (i in 1 until n) {
        val line = readLine()!!.split(" ")
        val newF = line[0].toFloatOrNull() ?: f
        val isCloser = line[1] == "closer"

        if (abs(newF - f) < 10e-6) continue

        if (isCloser) {
            if (newF < f) {
                finish = min(finish, (newF + f) / 2.0f)
            } else {
                start = max(start, (newF + f) / 2.0f)
            }
        } else {
            if (newF < f) {
                start = max(start, (newF + f) / 2.0f)
            } else {
                finish = min(finish, (newF + f) / 2.0f)
            }
        }

        f = newF
    }

    println("$start $finish")
}
