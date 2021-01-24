fun main(array: Array<String>) {
    println("Pow!")

    var x = 1
    println("Before the loop x = $x")
    while (x < 4) {
        println("In the loop x = $x")
        x += 1
    }
    println("After the loop x = $x")

    val y = 5
    println(if (x > y) "X is greater than y" else "X is not greater than y")

    x = 1
    while (x < 3) {
        print(if (x == 1) "Yab" else "Dab")
        print("ba")
        x += 1
    }
    if (x == 3) println("Doo")
}