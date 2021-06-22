import kotlin.math.abs

fun main(args: Array<String>) {
    val a = readLine()!!.toDouble()
    val b = readLine()!!.toDouble()
    val c = readLine()!!.toDouble()
    val d = readLine()!!.toDouble()
    val e = readLine()!!.toDouble()
    val f = readLine()!!.toDouble()

    val maxError = 10e-4

    if (a == 0.0 && b == 0.0 && c == 0.0 && d == 0.0 && e == 0.0 && f == 0.0) {
        print(5)
        return
    }

    if (a == 0.0 && c == 0.0) {
        if (b == 0.0 && e != 0.0) {
            print(0)
            return
        }
        if (d == 0.0 && f != 0.0) {
            print(0)
            return
        }
        if (b != 0.0 && d != 0.0) {
            val y1 = e / b
            val y2 = f / d

            val error = abs(y1 - y2)
            if (error > maxError) {
                print(0)
                return
            }
            print("4 ${(y1 + y2) / 2}")
            return
        }
        if (b != 0.0) {
            val y = e / b
            print("4 $y")
            return
        }
        if (d != 0.0) {
            val y = f / d
            print("4 $y")
            return
        }
    }

    if (b == 0.0 && d == 0.0) {
        if (a == 0.0 && e != 0.0) {
            print(0)
            return
        }
        if (c == 0.0 && f != 0.0) {
            print(0)
            return
        }
        if (a != 0.0 && c != 0.0) {
            val x1 = e / a
            val x2 = f / c

            val error = abs(x1 - x2)
            if (error > maxError) {
                print(0)
                return
            }
            print("3 ${(x1 + x2) / 2}")
            return
        }
        if (a != 0.0) {
            val x = e / a
            print("3 $x")
            return
        }
        if (c != 0.0) {
            val x = f / c
            print("3 $x")
            return
        }
    }


    try {
        val k1 = -a / b
        val b1 = e / b

        val k2 = -c / d
        val b2 = f / d

        if (k1.isFinite() && k2.isFinite() && b1.isFinite() && b2.isFinite() && abs(k1 - k2) < maxError * 10 && abs(b1 - b2) < maxError * 10) {
            print("1 ${(k1 + k2) / 2} ${(b1 + b2) / 2}")
            return
        }

        if (k1.isFinite() && b1.isFinite() && c == 0.0 && d == 0.0 && f == 0.0) {
            print("1 $k1 $b1")
            return
        }

        if (k2.isFinite() && b2.isFinite() && a == 0.0 && b == 0.0 && e == 0.0) {
            print("1 $k2 $b2")
            return
        }

    } catch (th: Throwable) {

    }

    try {
        var x = (d * e - b * f) / (d * a - b * c)
        var y = (c * e - a * f) / (c * b - a * d)

        if (x.isNaN() || x.isInfinite()) {
            val x1 = (e - b * y) / a
            val x2 = (f - d * y) / c

            if (!x1.isNaN() && !x1.isInfinite()) {
                x = x1
            }
            if (!x2.isNaN() && !x2.isInfinite()) {
                if (x.isNaN() || x.isInfinite()) {
                    x = x2
                } else {
                    if (abs(x - x2) > maxError) {
                        print(0)
                        return
                    }
                    x = (x + x2) / 2
                }
            }
        }

        if (y.isNaN() || y.isInfinite()) {
            val y1 = (e - a * x) / b
            val y2 = (f - c * x) / d

            if (!y1.isNaN() && !y1.isInfinite()) {
                y = y1
            }
            if (!y2.isNaN() && !y2.isInfinite()) {
                if (y.isNaN() || y.isInfinite()) {
                    y = y2
                } else {
                    if (abs(y - y2) > maxError) {
                        print(0)
                        return
                    }
                    y = (y + y2) / 2
                }
            }
        }

        if (x.isNaN() || y.isNaN() || x.isInfinite() || y.isInfinite()) {
            print(0)
            return
        }

        print("2 $x $y")
        return
    } catch (th: Throwable) {

    }

    print(0)
}
