package ru.netology

import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun testMASTERCARD() {
        val cardType = "MASTERCARD"
        val transferMonth = 0
        val summTransfer = 80000

        val result = transferMoney(cardType = cardType, transferMonth = transferMonth, summTransfer = summTransfer)

        assertEquals(500, result)
    }
    @Test
    fun testMASTERCARDNormal() {
        val cardType = "MASTERCARD"
        val transferMonth = 0
        val summTransfer = 50000

        val result = transferMoney(cardType = cardType, transferMonth = transferMonth, summTransfer = summTransfer)

        assertEquals(5, result)
    }
    @Test
    fun testMASTERCARDLimit() {
        val cardType = "MASTERCARD"
        val transferMonth = 0
        val summTransfer = 301

        val result = transferMoney(cardType = cardType, transferMonth = transferMonth, summTransfer = summTransfer)

        assertEquals(0, result)
    }

    @Test
    fun testMAESTRO() {
        val cardType = "MAESTRO"
        val transferMonth = 0
        val summTransfer = 90000

        val result = transferMoney(cardType = cardType, transferMonth = transferMonth, summTransfer = summTransfer)

        assertEquals(560, result)
    }
    @Test
    fun testMAESTRONormal() {
        val cardType = "MAESTRO"
        val transferMonth = 0
        val summTransfer = 30000

        val result = transferMoney(cardType = cardType, transferMonth = transferMonth, summTransfer = summTransfer)

        assertEquals(0, result)
    }
    @Test
    fun testMAESTROLimit() {
        val cardType = "MAESTRO"
        val transferMonth = 0
        val summTransfer = 900

        val result = transferMoney(cardType = cardType, transferMonth = transferMonth, summTransfer = summTransfer)

        assertEquals(0, result)
    }

    @Test
    fun testVISA() {
        val cardType = "VISA"
        val transferMonth = 0
        val summTransfer = 30000

        val result = transferMoney(cardType = cardType, transferMonth = transferMonth, summTransfer = summTransfer)

        assertEquals(225, result)
    }
    @Test
    fun testMIR() {
        val cardType = "MIR"
        val transferMonth = 0
        val summTransfer = 130000

        val result = transferMoney(cardType = cardType, transferMonth = transferMonth, summTransfer = summTransfer)

        assertEquals(975, result)
    }
    @Test
    fun testVkPay() {
        val cardType = "VK Pay"
        val transferMonth = 15_000
        val summTransfer = 13_000

        val result = transferMoney(cardType = cardType, transferMonth = transferMonth, summTransfer = summTransfer)

        assertEquals(0, result)
    }
    @Test
    fun testErrorType() {
        val cardType = "VebMomey"
        val transferMonth = 15_000
        val summTransfer = 13_000

        val result = transferMoney(cardType = cardType, transferMonth = transferMonth, summTransfer = summTransfer)

        assertEquals(ERROR_TYPE, result)
    }
    @Test
    fun testErrorLimitVk() {
        val cardType = "VK Pay"
        val transferMonth = 15_000
        val summTransfer = 15_001

        val result = transferMoney(cardType = cardType, transferMonth = transferMonth, summTransfer = summTransfer)

        assertEquals(-2, result)
    }
    @Test
    fun testErrorLimitVk2() {
        val cardType = "VK Pay"
        val transferMonth = 30_000
        val summTransfer = 13_000

        val result = transferMoney(cardType = cardType, transferMonth = transferMonth, summTransfer = summTransfer)

        assertEquals(ERROR_LIMIT_VK, result)
    }
    @Test
    fun testErrorLimitMonth() {
        val cardType = "MIR"
        val transferMonth = 570_000
        val summTransfer = 130_000

        val result = transferMoney(cardType = cardType, transferMonth = transferMonth, summTransfer = summTransfer)

        assertEquals(ERROR_LIMIT, result)
    }
    @Test
    fun testErrorLimitDay() {
        val cardType = "MIR"
        val transferMonth = 70_000
        val summTransfer = 155_000

        val result = transferMoney(cardType = cardType, transferMonth = transferMonth, summTransfer = summTransfer)

        assertEquals(ERROR_LIMIT, result)
    }
    @Test
    fun testDefaultValues() {
        val cardType = "MIR"
        val transferMonth = 50_000
        val summTransfer = 1_000

        val result = transferMoney( summTransfer = summTransfer)

        assertEquals(35, result)
    }

}