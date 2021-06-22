import java.io.*

fun main(args: Array<String>) {
    val input = BufferedReader(FileReader("input.txt"))
    val output = BufferedWriter(FileWriter("output.txt"))

    val a = input.readLine()!!.toLong()
    val b = input.readLine()!!.toLong()
    val c = input.readLine()!!.toLong()

	if (c < 0L) {
    	output.write("NO SOLUTION")
        output.flush()
        return
    }
    
    if (a == 0L) {
    	if (b == c * c) {
        	output.write("MANY SOLUTIONS")
        } else {
        	output.write("NO SOLUTION")
        }
        output.flush()
        return
    }
    
    val x = (c * c  - b) / a
    if (a * x + b == c * c) {
    	output.write(x.toString())
        output.flush()
        return
    } else {
    	output.write("NO SOLUTION")
        output.flush()
        return
    }
}
