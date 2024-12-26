package org.example.dp

fun subSetsK(idx:Int, holder:MutableList<Int>, currSum: Int, reqSum:Int, arr:IntArray) {
    if(idx == arr.size) {
        if(currSum == reqSum){
            holder.forEach{num -> print(num)}
            println()
        }
        return
    }

    val curr = arr[idx]
    //include
    holder.add(curr)
    subSetsK(idx + 1, holder, currSum + curr, reqSum, arr)

    //remove
    holder.remove(curr)
    subSetsK(idx + 1, holder, currSum, reqSum, arr)

}

fun main() {
    val arr = intArrayOf(1,2,1)
    val sum  = 2

    subSetsK(0, mutableListOf(), 0, sum, arr)
}