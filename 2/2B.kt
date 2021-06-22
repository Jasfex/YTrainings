fun main() {
    var constantSequenceElement: Long? = null
    var isConstantSequence = true

    var ascendingElement: Long? = null
    var isAscending = true

    var descendingElement: Long? = null
    var isDescending = true

    var ascendingWeakElement: Long? = null
    var isAscendingWeak = true

    var descendingWeakElement: Long? = null
    var isDescendingWeak = true

    while (true) {
        val number = readLine()!!.toLong()
        if (number == -2000000000L) {
            break
        }

        if (isConstantSequence) {
            if (constantSequenceElement == null) {
                constantSequenceElement = number
            } else if (constantSequenceElement != number) {
                isConstantSequence = false
            }
        }

        if (isAscending) {
            if (ascendingElement == null) {
                ascendingElement = number
            } else if (ascendingElement < number) {
                ascendingElement = number
            } else {
                isAscending = false
            }
        }

        if (isAscendingWeak) {
            if (ascendingWeakElement == null) {
                ascendingWeakElement = number
            } else if (ascendingWeakElement <= number) {
                ascendingWeakElement = number
            } else {
                isAscendingWeak = false
            }
        }

        if (isDescending) {
            if (descendingElement == null) {
                descendingElement = number
            } else if (descendingElement > number) {
                descendingElement = number
            } else {
                isDescending = false
            }
        }

        if (isDescendingWeak) {
            if (descendingWeakElement == null) {
                descendingWeakElement = number
            } else if (descendingWeakElement >= number) {
                descendingWeakElement = number
            } else {
                isDescendingWeak = false
            }
        }

    }

    if (isConstantSequence) {
        print("CONSTANT")
        return
    }

    if (isAscending) {
        print("ASCENDING")
        return
    }

    if (isDescending) {
        print("DESCENDING ")
        return
    }

    if (isAscendingWeak) {
        print("WEAKLY ASCENDING")
        return
    }

    if (isDescendingWeak) {
        print("WEAKLY DESCENDING")
        return
    }

    print("RANDOM")
}