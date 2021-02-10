package sealed

sealed class MessageType
class SuccessMessage(var msg: String) : MessageType()
class ErrorMessage(var msg: String, var e: Exception) : MessageType()
class NoneMessage() : MessageType()

fun main() {
    val message1 = SuccessMessage("Yay")
    val message2 = SuccessMessage("It worked!")
    val message3 = ErrorMessage("Boo!", Exception("smth went wrong"))
    val message4 = NoneMessage()

    var myMessageType: MessageType = message3

    val myMessage = when(myMessageType) {
        is SuccessMessage -> myMessageType.msg
        is ErrorMessage -> myMessageType.msg + " " + myMessageType.e.message
        is NoneMessage -> TODO()
    }

    println(myMessage)
}