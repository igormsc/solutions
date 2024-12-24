import java.util.*

class Solution273 {
    private val d2w = mapOf(1 to "One", 2 to "Two", 3 to "Three", 4 to "Four", 5 to "Five", 6 to  "Six", 7 to  "Seven", 8 to "Eight", 9 to "Nine", 10 to "Ten",
        11 to "Eleven", 12 to "Twelve", 13 to "Thirteen", 14 to "Fourteen", 15 to "Fifteen", 16 to "Sixteen", 17 to "Seventeen", 18 to "Eighteen", 19 to "Nineteen")
    private val tens = mapOf(2 to "Twenty", 3 to "Thirty", 4 to "Forty", 5 to "Fifty", 6 to "Sixty", 7 to "Seventy", 8 to "Eighty", 9 to "Ninety")
    private val inter = mapOf(3 to "Thousand", 6 to "Million", 9 to "Billion")
    private val interVals = mapOf("Thousand" to 3, "Million" to 6, "Billion" to 9)

    fun numberToWords(num: Int): String {
        if (num == 0) return "Zero"
        var digit = 0
        val res = LinkedList<String>()
        var num = num
        while (num>0) {
            val htd = num%1000
            num /= 1000
            if (htd>0) res.addFirst(wr(htd))
            digit += 3
            if (num>0) {
                if (res.isNotEmpty())   if (!interVals.containsKey(res.first())) res.addFirst(inter[digit])
                                        else res[0] = inter[digit]!!
                else res.add(inter[digit]!!)
            }
        }
        return res.joinToString(" ").trim()
    }

    private fun wr(htd: Int): String {
        val td = htd%100
        val h = htd/100
        val res = mutableListOf<String>()
        if (h>0) {res.add(d2w[h]!!); res.add("Hundred")}
        if (td==0) return res.joinToString(" ")
        if (td<20) { res.add(d2w[td]!!); return res.joinToString(" ") }
        val d = td%10
        val t = td/10
        if (d==0) { res.add(tens[t]!!); return res.joinToString(" ") }
        res.add(tens[t]!!)
        res.add(d2w[d]!!)
        return res.joinToString(" ")
    }

}
