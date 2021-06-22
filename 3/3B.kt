fun main() {
    val numbersA = readLine()!!.split(" ").map { it.toInt() }
    val numbersB = readLine()!!.split(" ").map { it.toInt() }
    val common = numbersA.toSet().intersect(numbersB.toSet())
    print(common.sorted().joinToString(" "))
}
