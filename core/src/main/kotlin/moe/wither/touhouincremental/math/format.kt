package moe.wither.touhouincremental.math

import java.util.*
import kotlin.math.pow

enum class Notation {

    Scientific

}

fun formatValue(value: BigDouble, notation: Notation = Notation.Scientific): String {
    when (notation) {
        Notation.Scientific -> {

            return if (value < 1e15) {
                "%,.0f".format(Locale.ENGLISH,value.mantissa * 10.0.pow(value.exponent.toDouble()))
            } else {
                "${"%.3f".format(Locale.ENGLISH, value.mantissa)}e${value.exponent}"
            }

        }
    }
}