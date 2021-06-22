fun main() {
    val numbers = readLine()!!.split(" ").map { it.toLongOrNull() }.filterNotNull()

    var firstMax = numbers[0]
    var secondMax = numbers[1]

    var firstMin = numbers[0]
    var secondMin = numbers[1]

    if (secondMax > firstMax) {
        val tmp = firstMax
        firstMax = secondMax
        secondMax = tmp
    }

    if (secondMin < firstMin) {
        val tmp = firstMin
        firstMin = secondMin
        secondMin = tmp
    }

    for (i in 2 until numbers.size) {
        val number = numbers[i]
        if (number > secondMax) {
            secondMax = number
        }
        if (number > firstMax) {
            val tmp = firstMax
            firstMax = number
            secondMax = tmp
        }

        if (number < secondMin) {
            secondMin = number
        }
        if (number < firstMin) {
            val tmp = firstMin
            firstMin = number
            secondMin = tmp
        }

    }

    if (firstMax * secondMax > firstMin * secondMin) {
        print("$secondMax $firstMax")
    } else {
        print("$firstMin $secondMin")
    }
}
