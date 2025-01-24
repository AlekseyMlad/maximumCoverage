package ru.netology

const val ERROR_LIMIT = -1
const val ERROR_LIMIT_VK = -2
const val ERROR_TYPE = -3

fun main() {
    val card1 = "MASTERCARD"
    val card2 = "MAESTRO"
    val card3 = "VISA"
    val card4 = "MIR"
    val card5 = "VK Pay"

    val transfer1 = 80_000
    val transfer2 = 10_000
    val transfer3 = 110_000
    val transfer4 = 290

    println("Перевод с карты $card1 сумма $transfer1 комиссия составит ${transferMoney(card1, 75_000, transfer1)} руб.")
    println("Перевод с карты $card2 сумма $transfer4 комиссия составит ${transferMoney(card2, 0, transfer4)} руб.")
    println(
        "Перевод с карты $card3 сумма $transfer3 комиссия составит ${
            transferMoney(
                card3,
                410_000,
                transfer3
            )
        } руб."
    )
    println("Перевод с карты $card4 сумма $transfer1 комиссия составит ${transferMoney(card4, 10_000, transfer1)} руб.")
    println("Перевод с карты $card5 сумма $transfer2 комиссия составит ${transferMoney(card5, 25_000, transfer2)} руб.")


}

fun transferMoney(cardType: String = "MIR", transferMonth: Int = 0, summTransfer: Int): Int {
    val limitDay = 150_000
    val limitMonth = 600_000


    if (summTransfer > limitDay || transferMonth + summTransfer > limitMonth) {
        return ERROR_LIMIT
    }


    var comission = when (cardType) {

        "VISA" -> maxOf((summTransfer * 0.0075).toInt(), 35)
        "MIR" -> maxOf((summTransfer * 0.0075).toInt(), 35)

        "MASTERCARD" -> {
            val startFreeLimit = 300
            val offFreeLimit = 75_000
            if (startFreeLimit < summTransfer && summTransfer < offFreeLimit) {
                val taxableAmount = if (transferMonth > offFreeLimit) {
                    summTransfer
                } else maxOf(0, transferMonth + summTransfer - offFreeLimit)
                if (taxableAmount > 0) (taxableAmount * 0.006).toInt() + 20 else 0
            } else ((summTransfer * 0.006).toInt() + 20)
        }
        "MAESTRO" -> {
            val startFreeLimit = 300
            val offFreeLimit = 75_000
            if (startFreeLimit < summTransfer && summTransfer < offFreeLimit) {
                val taxableAmount = if (transferMonth > offFreeLimit) {
                    summTransfer
                } else maxOf(0, transferMonth + summTransfer - offFreeLimit)
                if (taxableAmount > 0) (taxableAmount * 0.006).toInt() + 20 else 0
            } else ((summTransfer * 0.006).toInt() + 20)
        }

        "VK Pay" -> {
            val dayLimit = 15_000
            val monthLimit = 40_000
            if (summTransfer > dayLimit || transferMonth + summTransfer > monthLimit) {
                return ERROR_LIMIT_VK
            } else 0

        }

        else -> ERROR_TYPE

    }
    return comission
}