fun main() {
	val numbers = readLine()!!.split(" ").map { it.toInt() }
    print(numbers.toSet().size)
}
