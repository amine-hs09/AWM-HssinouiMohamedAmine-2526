fun main() {
    println("Have I spent more time using my phone today: ${compareTime(300, 250)}")
    println("Have I spent more time using my phone today: ${compareTime(300, 300)}")
    println("Have I spent more time using my phone today: ${compareTime(200, 220)}")
}
//a en b komen van (a300 B250)
fun compareTime(timeSpentToday: Int, timeSpentYesterday: Int): Boolean {
    return timeSpentToday > timeSpentYesterday
}