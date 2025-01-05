package string

fun compressString(str:String):String {
    if (str.isEmpty()) return "";

    val result = StringBuilder()
    var currentChar = str[0]
    var count = 1

    for (i in 1 until str.length) {
        if (currentChar == str[i]) {
            count++
        } else {
            result.append(currentChar)
            if (count > 1) result.append(count)
            currentChar = str[i]
            count = 1
        }
    }
    result.append(currentChar)
    if (count > 1) result.append(count)

    return result.toString()
}

fun main() {
  print(compressString("ssfsff"))
}
