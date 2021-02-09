fun Double.toDollar() : String {
    return "$$this"
}

fun main() {
    println(12.23.toDollar())
}