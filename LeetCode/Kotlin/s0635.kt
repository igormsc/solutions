class LogSystem() {
    private val logs = mutableSetOf<Log>()
    private val m = mutableMapOf("Year" to 4, "Month" to 7, "Day" to 10, "Hour" to 13, "Minute" to 16, "Second" to 19 )

    fun put(id: Int, timestamp: String?) = logs.add(Log(id, timestamp?:""))

    fun retrieve(s: String, e: String, gra: String?): List<Int> {
        val x = m[gra]?:0
        val s = s.substring(0, x)
        val e = e.substring(0, x)
        val res = mutableListOf<Int>()
        val dedup = mutableSetOf<String>()
        for (p in logs) {
            if (!dedup.contains(p.ts) && p.ts.substring(0, x) in s..e) { dedup.add(p.ts);  res.add(p.id)}
        }
        return res
    }

    internal class Log(var id: Int, var ts: String)

}

