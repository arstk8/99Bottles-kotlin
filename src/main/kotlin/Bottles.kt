class Bottles {
    fun song(): String {
        return verses(99, 0)
    }

    private fun verses(hi: Int, lo: Int): String {
        return hi.downTo(lo).joinToString("\n") { verseNumber -> verse(verseNumber) }
    }

    private fun verse(n: Int): String {
        return verseFor(n).text()
    }

    private fun verseFor(n: Int): Verse {
        return when (n) {
            0 -> Verse(n, this::noMore)
            1 -> Verse(n, this::lastOne)
            2 -> Verse(n, this::penultimate)
            else -> Verse(n, this::default)
        }
    }

    private fun noMore(verse: Verse): String {
        return "No more bottles of beer on the wall, " +
                "no more bottles of beer.\n" +
                "Go to the store and buy some more, " +
                "99 bottles of beer on the wall."
    }

    private fun lastOne(verse: Verse): String {
        return "1 bottle of beer on the wall, " +
                "1 bottle of beer.\n" +
                "Take it down and pass it around, " +
                "no more bottles of beer on the wall."
    }

    private fun penultimate(verse: Verse): String {
        return "2 bottles of beer on the wall, " +
                "2 bottles of beer.\n" +
                "Take one down and pass it around, " +
                "1 bottle of beer on the wall."
    }

    private fun default(verse: Verse): String {
        return "${verse.number} bottles of beer on the wall, " + "${verse.number} bottles of beer.\n" +
                "Take one down and pass it around, " + "${verse.number - 1} bottles of beer on the wall.";
    }
}

class Verse(val number: Int, private val lyrics: (verse: Verse) -> String) {
    fun text(): String {
        return lyrics(this)
    }
}
