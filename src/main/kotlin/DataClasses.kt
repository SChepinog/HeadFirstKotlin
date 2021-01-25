data class Receipt(val title: String, val isVegetarian: Boolean)

fun main() {
    val receipt1 = Receipt("Chicken with tomato", false)
    val receipt2 = Receipt("Chicken with tomato", false)
    println(receipt1 == receipt2)
    println(receipt1)
    val receipt3 = receipt1.copy(isVegetarian = false)
    println(receipt3)
    var title3 = receipt3.component1()
    var isVegetarian3 = receipt3.component2()
    val (title2, isVegetarian2) = receipt2

}