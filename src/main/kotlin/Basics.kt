import java.io.FileNotFoundException
import java.io.FileReader
import java.io.IOException
import java.util.Calendar


fun main() {
    var a:Long = 1;
    val b = 2;
    var c:Float = 3.0F;

    val d:Boolean = false;
    val e:String = "abhishek";
    val f:String = "hello ${e.length}";
    val g:String = "hello $e";
    val h:String = "hello \$e";

    println(f)
    println(g)
    println(h)
    println("${g.length}")
    println("hello ${test()}")


    val theQuestion = "Doctor who"
    val answer = "Theta Sigma"
    val correctAnswer = ""
    val message = if ("2" != "1") {
        "You are correct"
    }
    else{
        "Try again"
    }
    println(message)

    val c1 = Calendar.getInstance()
    val day = c1.get(Calendar.DAY_OF_WEEK)
    when (day) {
        1 -> println("Sunday")
        2 -> println("Monday")
        3 -> println("Tuesday")
        4 -> println("Wednesday")
        else -> {
            println("WTF")
        }
    }
    println(day)

    var str: String? = ""

    println(str)
    strictStr(str!!)

    var response:Long? = readLine()?.toInt()?.toLong()
    println("Hello $response")


    var count = 0
    val finish = 5
    while (count++ < finish) {
        println("counter = $count")
    }

//    val i:Int = 123000
//    val ans = i.toString().split("_")
//    println(ans)

    val words = "The quick brown fox".split(".")
    for(word in words) {
        println(word)
    }

    for (i in 1..10) {
        println(i)
    }

    try {
        val fileReader = FileReader("README.txt")
        var content = fileReader.read()
        println(content)
    }
    catch (ffe: FileNotFoundException) {
        println(ffe.message)
    }
    catch(ioe: IOException) {
        println(ioe.message)
    }


    fun String.abhishek(str:String) {
        println("I am Abhishek!")
    }

    val ans = "".abhishek("")

    fun Any?.toString1(): String {
        if (this == null) throw IOException("null")
        // after the null check, 'this' is autocast to a non-null type, so the toString() below
        // resolves to the member function of the Any class
        return toString()
    }

    null.toString1()

    var a1 = arrayOf(1,2,3)
    println("null checks")
    printArr(null)
}

fun printArr(arr: Array<Int>?) {
    arr?.forEach { elem -> println(elem) }
}

fun strictStr(str:String):String {
    return str
}

fun test():String {
    return "Ab"
}