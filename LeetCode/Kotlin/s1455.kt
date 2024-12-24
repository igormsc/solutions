class Solution1455 {
    fun isPrefixOfWord(sentence: String, searchWord: String): Int = sentence.split(" ").withIndex().find { it.value.startsWith(searchWord) }.let { if (it == null) -1 else it.index+1}

}