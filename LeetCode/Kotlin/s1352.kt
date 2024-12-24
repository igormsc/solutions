class ProductOfNumbers() {

    private var pr = mutableListOf(1)

    fun add(num: Int) {
        if (num==0) pr = mutableListOf(1)
        else pr.add(pr.last()*num)
    }

    fun getProduct(k: Int): Int = if (k>=pr.size) 0 else pr.last()/pr[pr.lastIndex-k]
}