fun tellSmthAboutX(x: Int) {
    println(
        when (x) {
            0 -> "X is Zero"
            1, 2 -> "X is 1 or 2"
            else -> "X is not 0, 1 or 2. X is $x"
        }
    )
}

fun main() {
    tellSmthAboutX(0)
    tellSmthAboutX(1)
    tellSmthAboutX(2)
    tellSmthAboutX(3)
}