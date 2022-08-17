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
            1 -> {
                "1 bottle of beer on the wall, " +
                        "1 bottle of beer.\n" +
                        "Take it down and pass it around, " +
                        "no more bottles of beer on the wall."
            }
            2 -> {
                "2 bottles of beer on the wall, " +
                        "2 bottles of beer.\n" +
                        "Take one down and pass it around, " +
                        "1 bottle of beer on the wall."
            }
            else -> {
                "$number bottles of beer on the wall, " +
                        "$number bottles of beer.\n" +
                        "Take one down and pass it around, " +
                        "${number - 1} bottles of beer on the wall."
            }
        }
    }
}
