import java.io.*

inline fun stringToNumber(str: String): String {
    var number = ""
    for (sym in str) {
        if (sym.isDigit()) {
            number += sym
        }
    }
    if (number.length == 7) {
        number = "8495" + number
    } else if (number[0] == '7') {
        number = "8" + number.substring(1)
    }
    return number
}


fun main(args: Array<String>) {
    val input = BufferedReader(FileReader("input.txt"))
    val output = BufferedWriter(FileWriter("output.txt"))

    val number = stringToNumber(input.readLine()!!)
    val numbers = (1..3).map { stringToNumber(input.readLine()!!) }
    numbers.forEach {
        val answer = if (number == it) { "YES\n"} else { "NO\n" }
        output.write(answer)
    }

    output.flush()
}
