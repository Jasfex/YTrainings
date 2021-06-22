fun main() {
    val n = readLine()!!.toInt()
    val elems = readLine()!!.split(" ").map { it.toInt() }
    val target = readLine()!!.toInt()
    val distances = elems.mapIndexed { index, it -> 
        index to if (it < target) target - it else it - target
    }
    val minIndex = distances.minByOrNull { it.second }!!.first
    print(elems[minIndex])
}
