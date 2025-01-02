package org.example.recursion

//Ref: https://youtu.be/eQCS_v3bw0Q?si=3DHt5p4ZLc_qGwrN
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

fun subSetsK_only1(idx:Int, holder:MutableList<Int>, currSum: Int, reqSum:Int, arr:IntArray): Boolean {
    if(idx == arr.size) {
        if(currSum == reqSum){
            holder.forEach{num -> print(num)}
            println()
            return true
        }
        return false
    }

    val curr = arr[idx]
    //include
    holder.add(curr)
    if (subSetsK_only1(idx + 1, holder, currSum + curr, reqSum, arr)) return true

    //remove
    holder.remove(curr)
    if (subSetsK_only1(idx + 1, holder, currSum, reqSum, arr)) return true

    return false
}

fun main() {
    val arr = intArrayOf(1,2,1)
    val sum  = 2

//    subSetsK(0, mutableListOf(), 0, sum, arr)
    subSetsK_only1(0, mutableListOf(), 0, sum, arr)
}