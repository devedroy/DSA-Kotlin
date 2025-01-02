package org.example.array

fun secondLargest_bf(arr:IntArray):Int {
    arr.sort()

    for (i in arr.size - 2 downTo 0) {
        if (arr.last() != arr[i]) return arr[i]
    }

    return -1
}

fun secondLargest_better(arr: IntArray):Int {
    var largest = arr[0]
    for (idx in 1 until arr.size) {
        if (arr[idx] > largest) largest = arr[idx]
    }

    var secondLargest = -1
    for (idx in arr.indices) {
        if (arr[idx] > secondLargest && arr[idx] != largest) secondLargest = arr[idx]
    }

    return secondLargest
}

fun secondLargest_optimal(arr: IntArray): Int {
    var largest = arr[0]
    var secondLargest = Int.MIN_VALUE
    for (idx in 1 until arr.size) {
        if (arr[idx] > largest) largest = arr[idx]
        if (arr[idx] > secondLargest && arr[idx] != largest) secondLargest = arr[idx]
    }
    return secondLargest
}

fun main() {
  val arr = intArrayOf(1,2,4,7,7,5)
//    print(secondLargest_bf(arr))
//    print(secondLargest_better(arr))
    print(secondLargest_optimal(arr))
}