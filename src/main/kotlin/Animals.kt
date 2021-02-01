package vets

abstract class Pet(var name: String)
class Cat(name: String) : Pet(name)
class Dog(name: String) : Pet(name)
class Fish(name: String) : Pet(name)

class Contest<T : Pet> (var vet : Vet<in T>) {
    var scores: MutableMap<T, Int> = mutableMapOf()
    fun addScore(t: T, score: Int) {
        if (score > 0) scores.putIfAbsent(t, score)
    }

    fun getWinners(): MutableSet<T> {
        val highscore = scores.values.maxOrNull()!!
        val winners: MutableSet<T> = mutableSetOf()
        for ((t, score) in scores) {
            if (score == highscore) winners.add(t)
        }
        return winners
    }
}

class PetOwner<T : Pet>(t: T) {
    val pets = mutableListOf(t)
    fun add(t: T) = pets.add(t)
    fun remove(t: T) = pets.remove(t)
}

interface Retailer<out T> {
    fun sell(): T
}

class CatRetailer : Retailer<Cat> {
    override fun sell(): Cat {
        println("Sell Cat")
        return Cat("")
    }
}

class DogRetailer : Retailer<Dog> {
    override fun sell(): Dog {
        println("Sell Dog")
        return Dog("")
    }
}

class FishRetailer : Retailer<Fish> {
    override fun sell(): Fish {
        println("Sell Fish")
        return Fish("")
    }
}

class Vet<T : Pet> {
    fun treat(t: T) {
        println("Treat per ${t.name}")
    }
}

fun main() {
    val catVet = Vet<Cat>()
    val contest = Contest<Cat>(catVet)
    contest.addScore(Cat("Murs"), 100)
    contest.addScore(Cat("Lusya"), 50)

    val catFuzz = Cat("Fuzz Lightyear")
    val catKatsu = Cat("Katsu")
    val fishFinny = Fish("Finny McGraw")

    val catContest = Contest<Cat>(catVet)
    catContest.addScore(catFuzz, 50)
    catContest.addScore(catKatsu, 56)
    val topCat = catContest.getWinners().first()
    println("Cat contest winner is ${topCat.name}")

    val petVet = Vet<Pet>()
    val petContest = Contest<Pet>(petVet)
    petContest.addScore(catFuzz, 50)
    petContest.addScore(fishFinny, 56)
    val topPet = petContest.getWinners().first()
    println("Pet contest winner is ${topPet.name}")

    val dogRetailer: Retailer<Dog> = DogRetailer()
    val petRetailer: Retailer<Pet> = CatRetailer() //out
    petRetailer.sell()

    catVet.treat(catFuzz)
    val catContestWithSuperVet = Contest<Cat>(Vet<Pet>()) //in
}
