fun getEntrance(flatNumber: Int, numFlatsOnFloor: Int, numFloors: Int): Int {
    return (flatNumber - 1) / (numFlatsOnFloor * numFloors) + 1
}

fun getFloor(flatNumber: Int, numFlatsOnFloor: Int, numFloors: Int): Int {
    val entrance = getEntrance(flatNumber, numFlatsOnFloor, numFloors)
    return (flatNumber - 1 - (entrance - 1) * numFlatsOnFloor * numFloors) / numFlatsOnFloor + 1
}

fun isPossible(flatNumber: Int, entranceNumber: Int, floorNumber: Int, numFlatsOnFloor: Int, numFloors: Int): Boolean {
    val entrance = getEntrance(flatNumber, numFlatsOnFloor, numFloors)
    val floor = getFloor(flatNumber, numFlatsOnFloor, numFloors)
    return entrance == entranceNumber && floor == floorNumber
}

fun main(args: Array<String>) {
    val input = readLine()!!.split(" ").map { it.toInt() }

    val k1 = input[0]
    val m = input[1]
    val k2 = input[2]
    val p2 = input[3]
    val n2 = input[4]

    val possibleEntrances = mutableSetOf<Int>()
    val possibleFloors = mutableSetOf<Int>()

    for (numFlatsOnFloor in 1..1_000_000) {
        if (isPossible(flatNumber = k2, entranceNumber = p2, floorNumber = n2, numFlatsOnFloor = numFlatsOnFloor, numFloors = m)) {
            val entrance = getEntrance(flatNumber = k1, numFlatsOnFloor = numFlatsOnFloor, numFloors = m)
            val floor = getFloor(flatNumber = k1, numFlatsOnFloor = numFlatsOnFloor, numFloors = m)
            possibleEntrances.add(entrance)
            possibleFloors.add(floor)
        }
    }

    if (possibleEntrances.size == 0 && possibleFloors.size == 0) {
        print("-1 -1")
        return
    }

    if (possibleEntrances.size == 1 && possibleFloors.size == 1) {
        print("${possibleEntrances.first()} ${possibleFloors.first()}")
        return
    }

    if (possibleEntrances.size == 1) {
        print("${possibleEntrances.first()} 0")
        return
    }

    if (possibleFloors.size == 1) {
        print("0 ${possibleFloors.first()}")
        return
    }

    print("0 0")
}
