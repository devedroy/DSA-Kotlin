package heap.intuit

import java.util.PriorityQueue

/*
 * Problem Statement:
You are given an array of integers where each element represents the count of balls. Each ball has weights in increasing order starting from 1. For example:
The first ball has a weight of 1.
The second ball has a weight of 2.
The third ball has a weight of 3, and so on.
You need to take out
𝑘
k balls with the highest weights and calculate their total weight. If a weight has multiple balls, exhaust them before moving to the next lower weight.
 */

fun heightWeight(of :Int, count: IntArray) :Int {
    val maxHeap = PriorityQueue<Int>(compareByDescending { it })
    for (i in 0 until count.size) {
        maxHeap.add(count[i])
    }

    var totalWeight = 0
    var looper = of
    while (maxHeap.isNotEmpty() && looper-- > 0) {
        val heightWeight = maxHeap.poll()
        totalWeight += heightWeight
        maxHeap.add(heightWeight - 1)
    }
    return totalWeight
}

/*[2,3,5]
 * 4 -> 5 + 4 + 3 + 3 = 15
 */

fun main() {
    val count = intArrayOf(2,3,5)
    print(heightWeight(4, count))
}

