class Bottles {
    fun song(): String {
        return verses(99, 0)
    }

    private fun verses(upper: Int, lower: Int): String {
        return upper.downTo(lower).joinToString("\n") { verseNumber -> verse(verseNumber) }
    }

    private fun verse(number: Int): String {
        return when (number) {
            0 -> {
                "No more bottles of beer on the wall, " +
                        "no more bottles of beer.\n" +
                        "Go to the store and buy some more, " +
                        "99 bottles of beer on the wall."
            }
            else -> {
                "$number ${container(number)} of beer on the wall, " +
                        "$number ${container(number)} of beer.\n" +
                        "Take ${pronoun(number - 1)} down and pass it around, " +
                        "${quantity(number - 1)} ${container(number - 1)} of beer on the wall."
            }
        }
    }

    private fun container(number: Int): String {
        return if (number == 1) {
            "bottle"
        } else {
            "bottles"
        }
    }

    private fun pronoun(number: Int): String {
        return if (number == 0) {
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
}
