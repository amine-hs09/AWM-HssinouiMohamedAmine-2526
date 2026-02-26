fun main() {    
    // van Celsius naar Fahrenheit
    printFinalTemperature(27.0, "Celsius", "Fahrenheit") { 9.0 / 5.0 * it + 32 }
    
    // van klevin naar Celsius
    printFinalTemperature(350.0, "Kelvin", "Celsius") { it - 273.15 }
    
    // van Fahrenheit naar kelvin 
    printFinalTemperature(10.0, "Fahrenheit", "Kelvin") { 5.0 / 9.0 * (it - 32) + 273.15 }
}

fun printFinalTemperature(
    //het cijfer dat we krijgen 
    initialMeasurement: Double, 
    initialUnit: String, 
    finalUnit: String, 
    // double die ik krijg terug naar een dubbel
    conversionFormula: (Double) -> Double
) {
    // cijfer van mijn berekening afronden twee decimaal 
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement)) // twee decimalen
   //het bericht structuur van terminal 
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}