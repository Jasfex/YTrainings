import java.io.*

fun main(args: Array<String>) {
  val input = BufferedReader(FileReader("input.txt"))
  val output = BufferedWriter(FileWriter("output.txt"))
  
  val numbers = input.readLine()!!.split(" ")
  val start = numbers[0].toInt()
  val target = numbers[1].toInt()
  val mode = input.readLine()!!
  
  val result = when (mode) {
  	"heat" -> {if (start < target) target else start}
    "freeze" -> {if (start > target) target else start}
    "auto" -> {target}
    "fan" -> {start}
    else -> {0}
  }
  
  output.write(result.toString())
  output.flush()
}
