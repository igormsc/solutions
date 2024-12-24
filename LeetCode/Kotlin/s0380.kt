import kotlin.random.Random

class RandomizedSet() {

    private val s = mutableSetOf<Int>()

    fun insert(`val`: Int): Boolean = s.add(`val`)

    fun remove(`val`: Int): Boolean = s.remove(`val`)

    fun getRandom(): Int = s.elementAt(Random.nextInt(0, s.size))

}
