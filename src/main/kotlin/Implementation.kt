interface A {
    fun myFunction() {
        println("From A")
    }
}

interface B {
    fun myFunction() {
        println("From B")
    }
}

class X : A,B {
    override fun myFunction() {
        super<A>.myFunction()
        super<B>.myFunction()
        println("From X")
    }
}

fun main() {
    X().myFunction()
}