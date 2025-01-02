package org.example.array

fun largestElement_bf(arr:IntArray):Int {
    arr.sort()
    return arr.last()
}

fun largestElment_optimal(arr: IntArray):Int {
    var largest = arr[0]

    for (i in 1 until arr.size) {
        if (arr[i] > largest) largest = arr[i]
    }

    return largest
}

fun main() {
    val arr = intArrayOf(3,2,1,5,2)
    //print(largestElement_bf(arr))
    print(largestElment_optimal(arr))
}