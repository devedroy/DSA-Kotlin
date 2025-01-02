package org.example.dp


fun fibonacci_recursion(at : Int): Int {
    if (at <= 1) return at
    return fibonacci_recursion(at - 1) + fibonacci_recursion(at - 2)
}

fun fibonacci_memoization(at: Int, dp:IntArray = IntArray(at + 1){-1}): Int {
    if (at <= 1) return at
    if (dp[at] != -1) return  dp[at]
    dp[at] = fibonacci_memoization(at - 1, dp) + fibonacci_memoization(at - 2, dp)
    return dp[at]
}


fun fibonacci_tabulation(at: Int): Int {
    val dp = IntArray(at + 1) { -1 }
    dp[0] = 0
    dp[1] = 1

    for (i in 2 ..at) {
        dp[i] = dp[i - 1] + dp[i - 2]
    }

    return dp[at]
}

fun fibonacci_pattern(at : Int) : Int {

    if (at <= 1) return  at

    var prev = 1
    var prev2 = 0

    for(i in 2..at) {
        val curr = prev + prev2
        prev2 = prev
        prev = curr
    }

    return prev
}



//0 1 1 2 3 5 8
fun main() {
    //print(fibonacci_recursion(6))
//    print(fibonacci_memoization(at = 6))
//    print(fibonacci_tabulation(6))
    print(fibonacci_pattern(6))
}