import java.io.File
import javax.sound.sampled.AudioSystem
import kotlinx.coroutines.*

suspend fun playBeats(beats: String, drum : Drum) {
    val parts = beats.split("x")
    var count = 0
    for (part in parts) {
        count += part.length + 1
        if (part  == "") {
            playSound(drum)
        } else {
            delay(100 * (part.length + 1L))
            if (count < beats.length) {
                playSound(drum)
            }
        }
    }
}

fun playSound(file: Drum) {
    var clip = AudioSystem.getClip()
    val audioInputStream = AudioSystem.getAudioInputStream(File("audio/${file.filename}"))
    clip.open(audioInputStream)
    clip.start()
}

enum class Drum(val filename : String) {
    CRASH_CYMBAL("crash_cymbal.aiff"),
    FLOOR_TOMS("floor_toms.aiff"),
    HIGH_HAT("high_hat.aiff"),
    KICK_DRUM("kick_drum.aiff"),
    SNARE("snare.aiff"),
    TOMS("toms.aiff")
}

suspend fun main() {
    runBlocking {
        launch { playBeats("x-x-x-x-x-x", Drum.TOMS) }
        playBeats("x-----x-----", Drum.CRASH_CYMBAL)
    }
}
