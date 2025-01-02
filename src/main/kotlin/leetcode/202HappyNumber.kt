package leetcode


class Solution {

    private fun sumOfSquare(of:Int):Int {
        var sum = 0
        var curr = of

        while (curr > 0) {
            val digit = curr % 10
            sum += digit * digit
            curr /= 10
        }

        return sum
    }

    fun isHappy(n: Int): Boolean {
        val seen:MutableSet<Int> = HashSet()
        var curr = n

        while (curr != 1 && !seen.contains(curr)) {
            seen.add(curr)
            curr = sumOfSquare(of=curr)
        }

        return curr == 1
    }
}

fun sumOfSquares(of:Int):Int{
    if (of == 0) return 0
    val digit = of % 10
    return digit * digit + sumOfSquares(of/10)
}

fun isNumHappy(n:Int, seen:MutableSet<Int> = HashSet()):Boolean {
    if (n == 1) return true
    if (seen.contains(n)) return false
    seen.add(n)
    return isNumHappy(sumOfSquares(n), seen)
}


fun main() {
    print(isNumHappy(19))
}
