class Bottles {
    fun song(): String {
        return verses(99, 0)
    }

    private fun verses(hi: Int, lo: Int): String {
        return hi.downTo(lo).joinToString("\n") { verseNumber -> verse(verseNumber) }
    }

    private fun verse(n: Int): String {
        return "${if (n == 0) "No more" else n} bottle${if (n == 1) "" else "s"}" +
                " of beer on the wall, " +
                "${if (n == 0) "no more" else n} bottle${if (n == 1) "" else "s"} of beer.\n" +
                (if (n > 0) "Take ${if (n > 1) "one" else "it"} down and pass it around, " else "Go to the store and buy some more, ") +
                        "${if (n - 1 < 0) 99 else if (n - 1 == 0) "no more" else n - 1} bottle${if (n - 1 == 1) "" else "s"} of beer on the wall."
    }
}
