fun main() {
	val numbers = readLine()!!.split(" ").map { it.toInt() }.toSet()
    val target = readLine()!!.map { it.toString().toInt() }.toSet()
    print((target - numbers).size)
}
