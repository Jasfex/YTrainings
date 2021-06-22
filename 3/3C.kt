import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.FileReader
import java.io.FileWriter
import java.util.*

fun main() {
    val input = BufferedReader(FileReader("input.txt"))
    val output = BufferedWriter(FileWriter("output.txt"))

    val line = input.readLine()!!.split(" ")
    val n = line[0].toInt()
    val m = line[1].toInt()
    val anya = TreeSet<Int>()
    val borya = TreeSet<Int>()

    for (i in 0 until n) {
        anya.add(input.readLine()!!.toInt())
    }

    for (i in 0 until m) {
        borya.add(input.readLine()!!.toInt())
    }

    val common = anya.clone() as TreeSet<Int>
    common.retainAll(borya)
    output.write(common.size.toString())
    output.newLine()
    output.write(common.joinToString(" "))
    output.newLine()

    output.flush()

    anya.removeAll(common)
    output.write(anya.size.toString())
    output.newLine()
    output.write(anya.joinToString(" "))
    output.newLine()

    output.flush()

    borya.removeAll(common)
    output.write(borya.size.toString())
    output.newLine()
    output.write(borya.joinToString(" "))
    output.newLine()

    output.flush()
}
