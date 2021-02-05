data class Grocery(val name: String, val category: String, val unit: String, val unitPrice: Double, val quantity: Int)

fun main() {
    val groceries = listOf(
        Grocery("Tomatoes", " Vegetable", "lb", 3.0, 3),
        Grocery("Mushrooms", " Vegetable", "lb", 4.0, 1),
        Grocery("Bagels", " Bakery", "Pack", 1.5, 2),
        Grocery("Olive oil", " Pantry", "Bottle", 6.0, 1),
        Grocery("Ice cream", " Frozen", "Pack", 3.0, 2)
    )

    val highestUnitPrice = groceries.maxByOrNull { it.unitPrice * 5 }
    println("highestUnitPrice: $highestUnitPrice")
    val lowestQuantity = groceries.minByOrNull { it.quantity }
    println("lowestQuantity: $lowestQuantity")

    val sumQuantity = groceries.sumBy { it.quantity }
    println("sumQuantity: $sumQuantity")
    val totalPrice = groceries.sumByDouble { it.quantity * it.unitPrice }
    println("totalPrice: $totalPrice")

    val vegetables = groceries.filter { it.category == "Vegetable" }
    println("vegetables: $vegetables")
    val notFrozen = groceries.filterNot { it.category== "Frozen" }
    println("notFrozen: $notFrozen")

    val groceryNames = groceries.map { it.name }
    println("groceryNames: $groceryNames")
    val halfUnitPrice = groceries.map { it.unitPrice * 0.5 }
    println("halfUnitPrice: $halfUnitPrice")

    val newPrices = groceries.filter { it.unitPrice > 3 }
        .map { it.unitPrice * 2 }
    println("newPrices: $newPrices")

    println("Grocery names: ")
    groceries.forEach { println(it.name) }

    println("Groceries with unitPrice > 3.0: ")
    groceries.filter { it.unitPrice > 3.0 }.forEach { println(it.name) }

    var itemNames = ""
    groceries.forEach { itemNames += "${it.name} " }
    println("itemNames: $itemNames")

}