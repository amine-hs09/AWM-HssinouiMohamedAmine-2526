

fun main() {
    val firstNumber = 10
    val secondNumber = 5
    val thirdNumber = 8
    
    val result = add(firstNumber, secondNumber)
    val anotherResult = add(firstNumber, thirdNumber)

// geef de print met berekening

    println("$firstNumber + $secondNumber = $result")
    println("$firstNumber + $thirdNumber = $anotherResult")
}
// hier is de logic van mijn berekeing met add
// a eerste add en  b add 2 
fun add(a: Int, b: Int): Int {
    return a + b
}  