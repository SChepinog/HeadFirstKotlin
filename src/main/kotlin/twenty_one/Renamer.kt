package twenty_one

import java.io.File
import java.nio.file.Files

fun main() {
    val pathToFiles = "/Volumes/My Book/User Manuals/torrent/21EA"
    val listOfAllFiles = File(pathToFiles).listFiles()!!.filter { it.isFile }

    val listOfFilesWithCompatibleNames = mutableListOf<File>()
    val listOfOfFilesWithIncompatibleNames = mutableListOf<File>()
    listOfAllFiles.forEach {
        if (isOk(it)) {
            listOfFilesWithCompatibleNames.add(it)
        } else {
            listOfOfFilesWithIncompatibleNames.add(it)
        }
    }
    listOfFilesWithCompatibleNames.forEach{
        try {rename(it) } catch (ex: IllegalArgumentException) {
            ex.printStackTrace()
        }
    }
    listOfOfFilesWithIncompatibleNames.forEach { move(it) }


}

fun isOk(file: File) : Boolean {
    println(file.name)
    return file.name.endsWith("_1080p.mp4") && file.name.split("_").size == 5
}

val men = setOf("Toby", "CharlieDean", "Renato", "Thomas", "VinceKarter", "KristofCale", "ThomasStone", "Eduard", "NikkiDikki",
    "SamBourne", "RaulCosta", "OliverTrunk", "IanScott", "DavidPerry", "JossLescaf", "NikkiNuttz", "MikeAngelo", "ThomasStone", "Lutro", "Jimmy")
fun rename(file: File) {
    val oldName = file.name
    val parts = oldName.split("_")
    val sceneNameCamelCase = parts[0]
    val actor1 = parts[2]
    val actor2 = parts[3]
    val actor = if (men.contains(actor1)) actor2 else if (men.contains(actor2)) actor1 else throw IllegalArgumentException("none of actors is man $actor1 $actor2")
    val newName = "${actor.decamelCaseName()} (${sceneNameCamelCase.decamelCase()}).mp4"
    println("rename $oldName to $newName")
    Files.move(file.toPath(), File(file.parentFile, newName).toPath())
}

fun String.decamelCaseName() : String {
    val result : StringBuilder = StringBuilder("")
    var notFirstLetter = false
    this.toCharArray().forEach {
        if (it == it.toUpperCase() && notFirstLetter) {
            result.append(" ")
        }
        notFirstLetter = true
        result.append(it)
    }
    return result.toString()
}

fun String.decamelCase() : String {
    val result : StringBuilder = StringBuilder("")
    var notFirstLetter = false
    this.toCharArray().forEach {
        if (it == it.toUpperCase() && notFirstLetter) {
            result.append(" ")
            result.append(it.toLowerCase())
        } else {
            notFirstLetter = true
            result.append(it)
        }
    }
    return result.toString()
}

fun move(file: File) {
    Files.move(file.toPath(), File(file.parentFile, "not processed/${file.name}").toPath())
}
