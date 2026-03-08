data class Event(
    val title: String,
    val description: String? = null,
    val daypart: String,
    val duration: Int,
)

fun main() {
    val event = Event(
        title = "Study Kotlin",
        description = "Commit to studying Kotlin at least 15 minutes per day.",
        daypart = "Evening",
        duration = 15
    )

    println(event)
}