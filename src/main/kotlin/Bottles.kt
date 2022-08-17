class Bottles {
    fun song(): String {
        return verses(99, 0)
    }

    private fun verses(upper: Int, lower: Int): String {
        return upper.downTo(lower).joinToString("\n") { verseNumber -> verse(verseNumber) }
    }

    private fun verse(number: Int): String {
        val bottleNumber = BottleNumber.bottleNumberFor(number)
        val successorBottleNumber = bottleNumber.successor()
        return capitalize("$bottleNumber of beer on the wall, ") +
                "$bottleNumber of beer.\n" +
                "${bottleNumber.action()}, " +
                "$successorBottleNumber of beer on the wall."
    }

    private fun capitalize(phrase: String): String {
        return phrase[0].uppercase() + phrase.substring(1)
    }
}

private class BottleNumber0(number: Int) : BottleNumber(number) {
    override fun quantity() = "no more"
    override fun action() = "Go to the store and buy some more"
    override fun successor() = bottleNumberFor(99)
}

private class BottleNumber1(number: Int) : BottleNumber(number) {
    override fun container() = "bottle"
    override fun pronoun() = "it"
}

private class BottleNumber6(number: Int) : BottleNumber(number) {
    override fun container() = "six-pack"
    override fun quantity() = "1"
}

private open class BottleNumber(private val number: Int) {

    override fun toString(): String {
        return "${quantity()} ${container()}"
    }

    open fun container() = "bottles"
    open fun pronoun() = "one"
    open fun quantity() = number.toString()
    open fun action() = "Take ${pronoun()} down and pass it around"
    open fun successor() = bottleNumberFor(number - 1)

    companion object {
        private enum class BottleNumberRegistry {
            BOTTLE0 {
                override fun getInstance(number: Int) = BottleNumber0(number)
                override fun canHandle(number: Int) = number == 0
            },
            BOTTLE1 {
                override fun getInstance(number: Int) = BottleNumber1(number)
                override fun canHandle(number: Int) = number == 1
            },
            BOTTLE6 {
                override fun getInstance(number: Int) = BottleNumber6(number)
                override fun canHandle(number: Int) = number == 6
            },
            OTHER {
                override fun getInstance(number: Int) = BottleNumber(number)
                override fun canHandle(number: Int) = true
            };

            abstract fun getInstance(number: Int): BottleNumber
            abstract fun canHandle(number: Int): Boolean
        }

        fun bottleNumberFor(number: Int): BottleNumber {
            return BottleNumberRegistry.values()
                .first { candidate -> candidate.canHandle(number) }
                .getInstance(number)
        }
    }
}
