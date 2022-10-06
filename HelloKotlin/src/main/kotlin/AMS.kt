import java.util.Calendar
import java.util.Random

fun main(args: Array<String>) {
    println("Hello, ${args[0]}")

    feedTheFish()

    // Function with all the test cods in STRING
    //stringTestCode(args)

    // Function that returns the actual day of the week
    //dayOfWeek()
}

fun randomDay() : String {
    val week = listOf("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")
    return week[Random().nextInt(7)]
}

fun feedTheFish() {
    val day = randomDay()
    val food = "pellets"
    println("Today is $day and the fish eats $food")
}

fun stringTestCode(args: Array<String>){

    // Example of a return of println
    val isUnit = println("This is an expression")
    println(isUnit)

    // Example of dynamic code with an if validation
    val temperature = 10
    var isHot = if (temperature > 50) true else false
    println(isHot)

    // Prints the message using dynamic code converting the args to the int type with an if validation in template string
    println("Good ${ if(args[0].toInt() < 12) "morning" else "night"} Kotlin")
}

fun dayOfWeek(){
    println("What day is it today?")
    var day : String = ""
    when(Calendar.getInstance().get(Calendar.DAY_OF_WEEK)) {
        1 -> day = "Sunday"
        2 -> day = "Monday"
        3 -> day = "Tuesday"
        4 -> day = "Wednesday"
        5 -> day = "Thursday"
        6 -> day = "Friday"
        7 -> day = "Saturday"
    }
    print("Today is $day")
}