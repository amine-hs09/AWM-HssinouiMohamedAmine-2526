enum class Daypart {
    MORNING,
    AFTERNOON,
    EVENING
}

data class Event(
    val title: String,
    val description: String? = null,
    val daypart: Daypart,
    val duration: Int,
)


fun main() {
    // mutablelistof is een lijst die om size te krijgen en flexibel om andere events aan lijst toetevoegen
    val events = mutableListOf(
        Event(title = "Wake up", description = "Time to get up", daypart = Daypart.MORNING, duration = 0),
        Event(title = "Eat breakfast", description = null, daypart = Daypart.MORNING, duration = 15),
        Event(title = "Learn about Kotlin", description = null, daypart = Daypart.AFTERNOON, duration = 30),
        Event(title = "Practice Compose", description = null, daypart = Daypart.AFTERNOON, duration = 60),
        Event(title = "Watch latest DevBytes video", description = null, daypart = Daypart.AFTERNOON, duration = 10),
        Event(title = "Check out latest Android Jetpack library", description = null, daypart = Daypart.EVENING, duration = 45)
    )

    val lastEvent = events.last()
    println("Last event: $lastEvent")
}
