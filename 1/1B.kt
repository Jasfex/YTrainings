import java.io.*

fun main(args: Array<String>) {
  val input = BufferedReader(FileReader("input.txt"))
  val output = BufferedWriter(FileWriter("output.txt"))
  
  val a = input.readLine()!!.toInt()
  val b = input.readLine()!!.toInt()
  val c = input.readLine()!!.toInt()
  
  val noC = c >= a + b
  val noB = b >= a + c
  val noA = a >= b + c
  
  val result = if (noC || noB || noA) "NO" else "YES"

  output.write(result.toString())
  output.flush()
}
