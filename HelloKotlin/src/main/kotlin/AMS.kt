import java.util.Calendar
import java.util.Random

fun main(args: Array<String>) {
    println("Hello, ${args[0]}")

    var teste = 1

    while (teste < 12) {
        teste = gamePlay(::rollDice2)
        println(teste)
    }

    //region Function of filter and sort challenge
    // filterAndSortChallenge()
    //endregion

    //region Example of list eager and lazy filter
    //eagerLazyExample()
    //endregion

    //region Example of return when condition without parameter (construct)
    //print(whatShouldIDoToday())
    //endregion

    //region Examples of default value in the arguments

    //print(canAddFish(10.0, listOf(3,3,3))) // OK (false)
    //print(canAddFish(8.0, listOf(2,2,2), hasDecorations = false)) // OK(true)
    //print(canAddFish(9.0, listOf(1,1,3), 3)) // OK (false)
    //print(canAddFish(10.0, listOf(), 7, true)) // OK(true)

    //endregion

    //region Function that returns an array value based in the user's input

    var fortune: String

    // Looping with repeat instruction
//    repeat(10) {
//        fortune = getFortune(getBirthday())
//        println("\nYour fortune is: $fortune")
//        if (fortune.contains("Take it easy")) break;
//    }

    // Looping with while instruction
//    var number = 0
//    while (number <= 10) {
//        fortune = getFortune(getBirthday())
//        println("\nYour fortune is: $fortune")
//        if (fortune.contains("Take it easy")) break;
//    }

    // Looping with for instruction
//    for (i in 1..10) {
//        fortune = getFortune(getBirthday())
//        println("\nYour fortune is: $fortune")
//        if (fortune.contains("Take it easy")) break;
//    }

    //endregion

    //region Function that returns an array value randomly
    //feedTheFish()
    //endregion

    //region Function with all the test cods of STRING
    //stringTestCode(args)
    //endregion

    //region Function that returns the actual day of the week
    //dayOfWeek()
    //endregion
}

//region Objects



//endregion

//region Functions

// Example of function as arguments without his own arguments (simplified)
fun gamePlay(operation: () -> Int): Int = operation()

// Example of typed arrow function
var rollDice : (Int) -> Int = { numberSides -> if (numberSides > 1) Random().nextInt(1, numberSides) else 1 }

// Example of non-typed arrow function
var rollDiceNonTyped = { Random().nextInt(1, 13) }

// Example of lambda with function type notation
fun rollDice2() = Random().nextInt(1, 13)

fun whatShouldIDoToday(weather: String = "Sunny", temperature: Int = 24) : String {
    println("What is your mood today? ")
    val mood = readLine()!!

    // when without a parameter
    return when {
        isGoodForWalk(mood, weather) -> "Go for a walk"
        isGoodStayInBed(mood, weather, temperature) -> "Stay in bed"
        isGoodToSwim(temperature) -> "Go swimming"
        else -> "Stay home and read"
    }

    // when with a single-expression function validation
}
// Examples of compact function
fun isGoodForWalk(mood: String, weather: String) = mood == "happy" && weather == "Sunny"
fun isGoodStayInBed(mood: String, weather: String, temperature: Int) = mood == "sad" && weather == "rainy" && temperature == 0
fun isGoodToSwim(temperature: Int) = temperature > 35

fun canAddFish(tankSize : Double, currentFish : List<Int>, fishSize : Int = 2, hasDecorations : Boolean = true) : Boolean {
var allFishSize : Int = fishSize

    for(element in currentFish)  allFishSize += element

    if(!hasDecorations){
        return allFishSize == tankSize.toInt()
    }
    else {
        val realTankSize = (80 * tankSize) / 100
        return allFishSize <= realTankSize.toInt()
    }

    // A better way to do this
    //return (tankSize * if (hasDecorations) 0.8 else 1.0) >= (currentFish.sum() + fishSize)
}

fun feedTheFish() {
    val day = randomDay()
    val food = "pellets"
    println("Today is $day and the fish eats $food")

    // Sequence of the example of default values to the arguments (function shouldChangeWater)
    shouldChangeWater(day, 20, 50)
    shouldChangeWater(day)
    shouldChangeWater(day, dirty = 50)
    shouldChangeWater(day = "Monday")

    if(shouldChangeWater(day)) {
        println("Change the water color today")
    }

    // Examples of lambda and arrow function
    dirtyProcessor()
}

// Example of compact function
fun feedFish(dirty: Int) = dirty + 10

// Examples of typed arrow function and lambda (respectively)
val waterFilter: (Int) -> Int = {dirty -> dirty / 2}

// Example of arrow function with a typed lambda
val waterFilter2 = {dirty: Int -> dirty / 2}
fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
    return operation(dirty)
}

var dirty = 20
fun dirtyProcessor(){
    dirty = updateDirty(dirty, waterFilter)
    dirty = updateDirty(dirty, ::feedFish)
    dirty = updateDirty(dirty) { dirty -> dirty + 50 }
}
fun shouldChangeWater(day: String, temperature: Int = 22, dirty: Int = 20) : Boolean {
    // Possibility of setting boolean validations at variables
    val isTooHot = temperature > 30
    val isDirty = dirty > 30
    val isSunday = day == "Sunday"

    // Variables above in when without parameter
    //region return when {
    //    isTooHot -> true
    //    isDirty -> true
    //    isSunday -> true
    //    else -> false
    //}
    //endregion

    // Boolean simplified functions in when without parameter
    return when {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else -> false
    }
}
fun isTooHot(temperature: Int) = temperature > 30
fun isDirty(dirty: Int) = dirty > 30
fun isSunday(day: String) = day == "Sunday"
fun randomDay() : String {
    val week = listOf("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")
    return week[Random().nextInt(7)]
}

//endregion

//region Arrays

fun filterAndSortChallenge(){
    val spices = listOf("curry", "pepper", "cayenne", "ginger", "red curry", "green curry", "red pepper" )

    // Example of filter and sort
    println("Filtering and crescent sorting: ${spices.filter{it.contains("curry")}.sortedBy { it.length }} \n")

    println("Filtering and decrescent sorting: ${spices.filter{it.contains("curry")}.sortedByDescending { it.length }} \n")

    // Example of filter startsWith and endWith
    println("First type of this filtering: ${spices.filter{it.startsWith('c') && it.endsWith('y')}} \n")

    println("Second type of this filtering: ${spices.filter{it[0] == 'c' && it[it.length - 1] == 'e'}} \n")

    // Example of filter taking the first three elements starting with the letter c
    spices.subList(0, 3).filter{it[0] == 'c'}
    println("Filtering taking the first three elements: $spices")
}

fun eagerLazyExample() {
    val decorations = listOf("rock", "pagoda", "plastic plant", "alligator", "flowerpot")

    // Example of eager filter
    val eager = decorations.filter {it[0] == 'p'}
    println(eager)

    val lazyMap = decorations.asSequence().filter{ it[0] == 'p'}
    println(lazyMap.toList())
}

fun getFortune(birthday : Int) : String {
    val list = listOf(
        "You will have a great day!",
        "Things will go well for you today.",
        "Enjoy a wonderful day of success.",
        "Be humble and all will turn out well.",
        "Today is a good day for exercising restraint.",
        "Take it easy and enjoy life!",
        "Treasure your friends because they are your greatest fortune."
    )

    return when (birthday) {
        in 0..6 -> list[0]
        in 7.. 13 -> list[1]
        in 14.. 20 -> list[2]
        in 21.. 27 -> list[3]
        in 28.. 31 -> list[4]
        else -> list[birthday.div(list.size)]
    }
}

fun getBirthday() : Int {
    println("Enter your birthday: ")
    return readLine()?.toIntOrNull() ?: 1
}


//endregion

//region Strings

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

//endregion