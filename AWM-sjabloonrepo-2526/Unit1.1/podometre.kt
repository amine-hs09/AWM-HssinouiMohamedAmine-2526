fun main() {
    val steps = 4000
    val caloriesBurned = pedometerStepsToCalories(steps)
    println("Walking $steps steps burns $caloriesBurned calories") 
}
// maak de berekening 
fun pedometerStepsToCalories(numberOfSteps: Int): Double {
    val caloriesBurnedForEachStep = 0.04
    val totalCaloriesBurned = numberOfSteps * caloriesBurnedForEachStep
    return totalCaloriesBurned
}