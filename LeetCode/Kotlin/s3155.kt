class Solution3155 {
    fun maxUpgrades(count: IntArray, upgrade: IntArray, sell: IntArray, money: IntArray): IntArray =
        count.indices.fold(mutableListOf<Int>()) { r, i ->
            r.add(minOf(count[i], ((count[i].toLong() * sell[i] + money[i]) / (upgrade[i].toLong() + sell[i])).toInt())); r }.toIntArray()
}