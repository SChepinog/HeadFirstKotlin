import java.util.*
import java.util.stream.Collectors
import java.util.stream.Stream
import kotlin.random.Random

fun main() {
    val options = arrayOf("Rock", "Paper", "Scissors")
    val gameChoice = getOption(options)
    val userChoice = getUserChoice(options)
    printResult(gameChoice, userChoice)
}

fun printResult(gameChoice: String, userChoice: String) {
    if (gameChoice == userChoice) {
        println("Tie!")
    } else {
        if ((gameChoice == "Rock" && userChoice == "Paper") ||
            (gameChoice == "Paper" && userChoice == "Scissors") ||
            (gameChoice == "Scissors" && userChoice == "Rock")) {
            println("You win!")
        } else {
            println("You lose!")
        }
    }
}

fun getOption(options: Array<String>) = options[Random.nextInt(options.size)]

fun getUserChoiceFast(options: Array<String>) : String {
    val choices = Arrays.stream(options).collect(Collectors.joining(", "))
    println("Choose one of the following $choices")
    val userInput = readLine()
    return if (userInput!= null && options.contains(userInput)) userInput else getUserChoiceFast(options)
}

fun getUserChoice(options: Array<String>) : String {
    var isValidChoice = false;
    var userChoice = ""
    while (!isValidChoice) {
        val choices = Arrays.stream(options).collect(Collectors.joining(", "))
        println("Choose one of the following $choices.")
        val userInput = readLine()
        if (userInput != null && userInput in options) {
            isValidChoice = true
            userChoice = userInput
        }
        if (!isValidChoice) println("You must enter a valid choice!")
    }
    return userChoice
}