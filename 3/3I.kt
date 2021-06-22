fun main() {
    val counter = mutableMapOf<String, Int>()
    val n = readLine()!!.toInt()
    for (i in 0 until n) {
        val m = readLine()!!.toInt()
        for (j in 0 until m) {
            val language = readLine()!!
            if (!counter.contains(language)) {
                counter[language] = 0
            }
            counter[language] = counter[language]!! + 1
        }
    }

    var allKnownLangs = mutableListOf<String>()
    for (language in counter.keys) {
        if (counter[language]!! == n) {
            allKnownLangs.add(language)
        }
    }
    println(allKnownLangs.size)
    println(allKnownLangs.joinToString("\n"))
    println(counter.keys.size)
    println(counter.keys.joinToString("\n"))
}
