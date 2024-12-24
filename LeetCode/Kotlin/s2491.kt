class Solution2491 {
    fun dividePlayers(skill: IntArray): Long {
        skill.sort()
        var mx = 0L
        var (l,r) = 0 to skill.lastIndex
        val s = skill[l] + skill[r]
        while (l<=r)
            if (s != skill[l] + skill[r]) return -1
            else mx += skill[l++]*skill[r--].toLong()

        return mx
    }
}
