fun main() {
    val firstNumber = 10
    val secondNumber = 5
    val thirdNumber = 8
    
    val additionResult = add(firstNumber, secondNumber)
    println("$firstNumber + $secondNumber = $additionResult")
    

    val subtractResult = subtract(firstNumber, thirdNumber)
    println("$firstNumber - $thirdNumber = $subtractResult")
}

fun add(a: Int, b: Int): Int {
    return a + b
}

fun subtract(a: Int, b: Int): Int {
    return a - b
}