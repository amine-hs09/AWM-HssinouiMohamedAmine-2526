fun main() {    
    // de instance 
    //heeft geen referer  door die null 
    val amanda = Person("Amanda", 33, "play tennis", null)
    val atiqah = Person("Atiqah", 28, "climb", amanda)
    
    // een methode die de instance roept via showprofile 
    amanda.showProfile()
    atiqah.showProfile()
}

// declatatie van class
class Person(
    val name: String,     
    val age: Int,          
    val hobby: String?,    // nulable porpertie 
    // referrer personne afiche info van de instance 
    val referrer: Person?  // Propriété nulable type composition exemple  het kan link maken tussen  twee instance van zelfde klasse
)
{
    // methode  
    fun showProfile() { //terminal message 
        println("Name: $name") 
        println("Age: $age")
        
        // if else != niet gelijk aan null 
        if (hobby != null) {
            print("Likes to $hobby. ")
        }
        
        // Vérification de la propriété referrer
        if (referrer != null) {
            // smart cast van geen null binnen 
            print("Has a referrer named ${referrer.name}") // 

            // 
            if (referrer.hobby != null) {
                print(", who likes to ${referrer.hobby}.")
            } else {
                print(".")
            }
        } else {
            // indien referer is null dan toon else 
            print("Doesn't have a referrer.")
        }
        
    }
}