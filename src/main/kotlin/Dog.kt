class Dog(val name: String, weight_param: Int, breed_param: String) {
    init {
        println("Dog named $name is being creating")
    }

    var activities = arrayOf("Walks")
    val breed = breed_param.toUpperCase()

    init {
        println("Breed is $breed")
    }

    var weight = weight_param
        set(value) {
            if (value > 0) field = value
        }
    val weightInKg: Double
        get() = weight / 2.2

    fun bark() {
        println(if (weight < 20) "Yip!" else "Woof!")
    }
}

fun main() {
    val myDog = Dog("Fido", 70, "Mixed")
    myDog.bark()
    myDog.weight = 75
    println("Weight in kilos is ${myDog.weightInKg}")
    myDog.weight = -2
    println("Weight is ${myDog.weight}")
    println("Weight in kilos is ${myDog.weightInKg}")
    myDog.activities = arrayOf("Walks", "Fetching balls", "Frisbee")
    for (item in myDog.activities) {
        println("My dog enjoys $item")
    }

    val dogs = arrayOf(Dog("Kelpie", 20, "Westie"), Dog("Ripper", 10, "Poodle"))
    dogs[1].bark()
    dogs[1].weight = 15
    println("Weight for ${dogs[1].name} is ${dogs[1].weight}")
}