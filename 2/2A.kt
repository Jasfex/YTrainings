fun main() {
	val input = readLine()!!.split(" ").map { it.toLong() }
    var x = input[0]
    for (index in 1 until input.size) {
    	if (input[index] > x) {
        	x = input[index]
        } else {
        	print("NO")
            return
        }
    }
    print("YES")
}
