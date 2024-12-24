class Solution1125 {
    fun smallestSufficientTeam(req_skills: Array<String>, people: List<List<String>>): IntArray {
        val skills = mutableMapOf<String, Int>()
        val n = req_skills.size
        req_skills.indices.forEach { skills[req_skills[it]] = it}
        val m = people.size
        val peopleSkill = IntArray(m)
        peopleSkill.indices.forEach { i ->
            people[i].indices.forEach { j -> peopleSkill[i] = peopleSkill[i].or(1.shl(skills[people[i][j]]?:0)) }
        }
        val s = 1.shl(n)
        val dp = IntArray(s) { Int.MAX_VALUE }.also{it[0]=0}
        val parent = IntArray(s) {-1}
        val state = IntArray(s)
        (0..<1.shl(n)).forEach { i ->
            (0..<m).forEach { j ->
                if (dp[i] != Int.MAX_VALUE) {
                    val t = i.or(peopleSkill[j])
                    if (dp[t] > dp[i]+1) {
                        parent[t] = j
                        state[t] = i
                        dp[t] = dp[i] + 1
                    }
                }
            }
        }
        var t = 1.shl(n) - 1
        val res = mutableListOf<Int>()
        while (parent[t] != -1) {
            res.add(parent[t])
            t = state[t]
        }
        return res.toIntArray()
    }
}
