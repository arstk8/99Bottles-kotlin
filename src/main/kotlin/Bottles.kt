class Bottles {
    fun song(): String {
        return verses(99, 0)
    }

    private fun verses(upper: Int, lower: Int): String {
        return upper.downTo(lower).joinToString("\n") { verseNumber -> verse(verseNumber) }
    }

    private fun verse(number: Int): String {
        return "${capitalize(quantity(number))} ${container(number)} of beer on the wall, " +
                "${quantity(number)} ${container(number)} of beer.\n" +
                "${action(number)}, " +
                "${quantity(successor(number))} ${container(successor(number))} of beer on the wall."
    }

    private fun container(number: Int): String {
        return if (number == 1) {
            "bottle"
        } else {
            "bottles"
        }
    }

    private fun pronoun(number: Int): String {
        return if (number == 1) {
            "it"
        } else {
            "one"
        }
    }

    private fun quantity(number: Int): String {
        return if (number == 0) {
            "no more"
        } else {
            number.toString()
        }
    }

    private fun action(number: Int): String {
        return if (number == 0) {
            "Go to the store and buy some more"
        } else {
            "Take ${pronoun(number)} down and pass it around"
        }
    }

    private fun successor(number: Int): Int {
        return if (number == 0) {
            99
        } else {
            number - 1
        }
    }

    private fun capitalize(phrase: String): String {
        return phrase[0].uppercase() + phrase.substring(1)
    }
}
