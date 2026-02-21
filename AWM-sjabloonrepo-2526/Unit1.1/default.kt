// step 1 

fun main() {
    val operatingSystem = "Chrome OS"
    val emailId = "sample@gmail.com"

    // geef 2 string information 
    println(displayAlertMessage(operatingSystem, emailId))
}

// de functie vraag geef me string van boven 
fun displayAlertMessage(operatingSystem: String, emailId: String): String {
    return "There's a new sign-in request on $operatingSystem for your Google Account $emailId."
}


stepp2

fun main() {
    // ik ken gewoon de eerste mail 
    val firstUserEmailId = "user_one@gmail.com"
    println(displayAlertMessage(emailId = firstUserEmailId))
    println()

    // 2ème cas : ik ken de twee infos windows 
    val secondUserOperatingSystem = "Windows"
    val secondUserEmailId = "user_two@gmail.com"
    println(displayAlertMessage(secondUserOperatingSystem, secondUserEmailId))
    println()

    // 3ème cas : de twee apple 
    val thirdUserOperatingSystem = "Mac OS"
    val thirdUserEmailId = "user_three@gmail.com"
    println(displayAlertMessage(thirdUserOperatingSystem, thirdUserEmailId))
    println()
}

//  unkown os  plus bericht opvolging 
fun displayAlertMessage(
    operatingSystem: String = "Unknown OS",
    emailId: String
): String {
    return "There's a new sign-in request on $operatingSystem for your Google Account $emailId."
}