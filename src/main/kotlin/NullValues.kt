class Wolf {
    var hunger = 10
    val food = "meat"
    fun eat() {
        println("The wolf is eating $food")
    }
}

class MyWolf {
    var wolf: Wolf? = Wolf()

    fun myFunction() {
        wolf?.eat()
    }
}

fun getAlphaWolf(): Wolf? {
    return Wolf()
}

fun main() {
    var w: Wolf? = Wolf()
    if (w != null) {
        w.eat()
    }
    var x = w?.hunger
    println("The value of X is $x")
    var y = w?.hunger ?: -1
    println("THe value of y is $y")

    var myWolf = MyWolf()
    myWolf?.wolf?.hunger = 0
    println("The value of myWolf?.wolf?.hunger is ${myWolf?.wolf?.hunger}")

    val myArray = arrayOf("Hi", "Hello", null)
    for (item in myArray) {
        item?.let { println(it) }
    }

    getAlphaWolf()?.let { it.eat() }

    w = null
//    var z = w!! //uncomment to get NPE

}