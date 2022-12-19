package moe.wither.touhouincremental.math

import kotlin.math.pow

enum class Notation {

    Scientific

}

fun formatValue(value: BigDouble, notation: Notation = Notation.Scientific): String {
    when (notation) {
        Notation.Scientific -> {

            return if (value < 1e15) {
                "Score : ${"%,.0f".format(value.mantissa * 10.0.pow(value.exponent.toDouble()))}"
            } else {
                "Score : ${String.format("%.3f", value.mantissa)}e${value.exponent}"
            }

        }
    }
}