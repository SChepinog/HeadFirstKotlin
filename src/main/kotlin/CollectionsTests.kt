fun main() {
    val shopping = listOf("Tea", "Eggs", "Milk")
    if (shopping.contains("Milk")) {
        println(shopping.indexOf("Milk"))
    }
    for (item in shopping) println(item)

    val mShopping = mutableListOf("Tea", "Eggs")
    mShopping.add("Milk")
    mShopping.add(1, "Milk")
    println(mShopping)
    mShopping.remove("Milk")
    println(mShopping)
    if (mShopping.size > 1) {
        mShopping.removeAt(1)
    }
    println(mShopping)
    if (mShopping.size > 0) {
        mShopping.set(0, "Coffee")
    }
    println(mShopping)
}