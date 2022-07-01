fun main(args: Array<String>) {
    print("for (i in 1..5) print(i) = ")
    for (i in 1..5) print(i)

    println()

    print("for (i in 5..1) print(i) = ")
    for (i in 5..1) print(i)             // prints nothing

    println()

    print("for (i in 5 downTo 1) print(i) = ")
    for (i in 5 downTo 1) print(i)

    println()

    print("for (i in 1..5 step 2) print(i) = ")
    for (i in 1..5 step 2) print(i)

    println()

    print("for (i in 5 downTo 1 step 2) print(i) = ")
    for (i in 5 downTo 1 step 2) print(i)

    println("List Iteration")
    var language = arrayOf("Ruby", "Kotlin", "Python", "Java")

    for (item in language)
        println(item)

    for (item in language.indices) {

        // printing array elements having even index only
        if (item%2 == 0)
            println(language[item])
    }

    println("string letter iteration")
    var text= "Kotlin"

    for (letter in text) {
        println(letter)
    }

    println("string letter iteration with indices")
    for (item in text.indices) {
        println(text[item])
    }

    var a:String = "Let's take LeetCode contest"
    a = reverseWords(a)
    println(a)

}

/**

Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:

Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Example 2:

Input: s = "God Ding"
Output: "doG gniD"


Constraints:

1 <= s.length <= 5 * 104
s contains printable ASCII characters.
s does not contain any leading or trailing spaces.
There is at least one word in s.
All the words in s are separated by a single space.


 */
fun reverseWords(s: String): String {
    return s.split(" ").joinToString(" ") { it.reversed() }
}