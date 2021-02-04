typealias DoubleConversion = (Double) -> Double

fun convert(x: Double, converter: DoubleConversion) : Double {
    val result = converter(x)
    println("$x is converted to $result")
    return result
}

fun getConversionLambda(str: String) : DoubleConversion {
    when (str) {
        "CentigradeToFahrenheit" -> {
            return {it * 1.8 + 32}
        }
        "KgToPounds" -> {
            return {it * 2.204623}
        }
        "PoundsToUSTons" -> {
            return {it / 2000}
        }
        else -> {
            return {it}
        }
    }
}

fun combine(lambda1: DoubleConversion, lambda2:DoubleConversion) : DoubleConversion {
    return {x -> lambda2(lambda1(x))}
}

fun main() {
    println("Convert 2.5 kilos to pounds: ${getConversionLambda("KgToPounds")(2.5)}")

    val kgToPounds = getConversionLambda("KgToPounds")
    val poundsToUSTonsLambda = getConversionLambda("PoundsToUSTons")
    val kgToUSTonsLambda = combine(kgToPounds, poundsToUSTonsLambda)
    val value = 17.4
    println("$value kgs is ${convert(value, kgToUSTonsLambda)} US Tons")
}