import java.lang.Long.max
import kotlin.math.abs

fun main(args: Array<String>) {
    val input = readLine()!!.split(" ").map { it.toLong() }
    val n = input[0]
    val k = input[1]
    val m = input[2]

    var numMaterials = n
    var numDetailsTotal = 0L

    while (numMaterials >= k) {
        val numResources = numMaterials / k
        val numDetails = (k / m) * numResources

        if (numDetails == 0L) {
            break
        }
        
        numDetailsTotal += numDetails
        numMaterials -= numDetails * m
    }

    print(numDetailsTotal)
}
