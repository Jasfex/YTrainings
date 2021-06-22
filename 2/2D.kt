fun main() {
    var cnt = 0
    val numbers = readLine()!!.split(" ").map { it.toInt() }
    for (i in 1 until numbers.size - 1) {
        if (numbers[i] > numbers[i-1] && numbers[i] > numbers[i+1]) {
            cnt++
        }
    }
    print(cnt)
}
