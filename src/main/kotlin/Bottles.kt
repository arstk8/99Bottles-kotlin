class Bottles {
    fun song(): String {
        return verses(99, 0)
    }

    private fun verses(upper: Int, lower: Int): String {
        return upper.downTo(lower).joinToString("\n") { verseNumber -> verse(verseNumber) }
    }

    private fun verse(number: Int): String {
        val bottleNumber = BottleNumber(number)
        val successorBottleNumber = BottleNumber(bottleNumber.successor())
        return "${capitalize(bottleNumber.quantity())} ${bottleNumber.container()} of beer on the wall, " +
                "${bottleNumber.quantity()} ${bottleNumber.container()} of beer.\n" +
                "${bottleNumber.action()}, " +
                "${successorBottleNumber.quantity()} ${successorBottleNumber.container()} of beer on the wall."
    }

    private fun capitalize(phrase: String): String {
        return phrase[0].uppercase() + phrase.substring(1)
    }
}

private class BottleNumber(private val number: Int) {
    fun container(): String {
        return if (number == 1) {
            "bottle"
        } else {
            "bottles"
        }
    }

    fun pronoun(): String {
        return if (number == 1) {
            "it"
        } else {
            "one"
        }
    }

    fun quantity(): String {
        return if (number == 0) {
            "no more"
        } else {
            number.toString()
        }
    }

    fun action(): String {
        return if (number == 0) {
            "Go to the store and buy some more"
        } else {
            "Take ${pronoun()} down and pass it around"
        }
    }

    fun successor(): Int {
        return if (number == 0) {
            99
        } else {
            number - 1
        }
    }
}
