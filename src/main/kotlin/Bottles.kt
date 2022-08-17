class Bottles {
    fun song(): String {
        return verses(99, 0)
    }

    private fun verses(bottlesAtStart: Int, bottlesAtEnd: Int): String {
        return bottlesAtStart.downTo(bottlesAtEnd).joinToString("\n") { verseNumber -> verse(verseNumber) }
    }

    private fun verse(bottles: Int): String {
        return Round(bottles).toString()
    }
}

class Round(private var bottles: Int) {
    override fun toString(): String {
        return challenge() + response()
    }

    private fun challenge(): String {
        return capitalize(bottlesOfBeer()) + " " + onWall() + ", " + bottlesOfBeer() + ".\n"
    }

    private fun response(): String {
        return goToTheStoreOrTakeOneDown() + ", " + bottlesOfBeer() + " " + onWall() + "."
    }

    private fun bottlesOfBeer(): String {
        return anglicizedBottleCount() + " " + pluralizedBottleForm() + " of " + beer()
    }

    private fun beer() = "beer"

    private fun onWall() = "on the wall"

    private fun pluralizedBottleForm() = if (isLastBeer()) "bottle" else "bottles"

    private fun anglicizedBottleCount() = if (isAllOut()) "no more" else bottles.toString()

    private fun goToTheStoreOrTakeOneDown(): String {
        return if (isAllOut()) {
            bottles = 99;
            buyNewBeer()
        } else {
            val lyrics = drinkBeer()
            bottles--
            lyrics
        }
    }

    private fun buyNewBeer() = "Go to the store and buy some more"

    private fun drinkBeer() = "Take ${this.itOrOne()} down and pass it around"

    private fun itOrOne() = if (isLastBeer()) "it" else "one"

    private fun isAllOut() = this.bottles == 0

    private fun isLastBeer() = this.bottles == 1

    private fun capitalize(value: String): String {
        return value[0].uppercase() + value.substring(1)
    }
}
