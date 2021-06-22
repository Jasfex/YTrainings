import kotlin.math.min

fun main() {
    val gen1 = readLine()!!
    val gen2 = readLine()!!

    val pairs1 = mutableMapOf<String, Int>()
    val pairs2 = mutableMapOf<String, Int>()

    for (i in 1 until gen1.length) {
        val pair = "${gen1[i-1]}${gen1[i]}"
        if (!pairs1.contains(pair)) {
            pairs1[pair] = 0
        }
        pairs1[pair] = pairs1[pair]!! + 1
    }

    for (i in 1 until gen2.length) {
        val pair = "${gen2[i-1]}${gen2[i]}"
        if (!pairs2.contains(pair)) {
            pairs2[pair] = 0
        }
        pairs2[pair] = pairs2[pair]!! + 1
    }

    var commonValue = 0
    for (pair in pairs1.keys) {
        if (pairs2.contains(pair)) {
            commonValue += pairs1[pair]!!
        }
    }

    print(commonValue)
}
