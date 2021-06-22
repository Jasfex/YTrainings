fun main(args: Array<String>) {
    val a = readLine()!!.toInt()
    val b = readLine()!!.toInt()
    val c = readLine()!!.toInt()
    val d = readLine()!!.toInt()
    val e = readLine()!!.toInt()

    val sides = listOf(a, b, c).sorted()
    if (sides[0] <= d && sides[1] <= e || sides[0] <= e && sides[1] <= d) {
        print("YES")
    } else {
        print("NO")
    }
}
