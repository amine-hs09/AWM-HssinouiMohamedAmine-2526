// super classe open voor de heritage 
open class Phone(var isScreenLightOn: Boolean = false) {
    
    // ik voeg open hier zodra subclas kan terug modifieren  
    open fun switchOn() {
        isScreenLightOn = true
    }
    
    // deze niet open zal zo blijven 
    fun switchOff() {
        isScreenLightOn = false
    }
    
    // if else expresion voor de lightscreen 
    fun checkPhoneScreenLight() {  
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}

// stap 2 
 // Phone() subclase van phone 
class FoldablePhone(var isFolded: Boolean = true) : Phone() {
    
    // 3. overide van de parent boven 
    override fun switchOn() {
        //scherm niet geploeit niet open 
        //! inverse les true wordt fals 
        if (!isFolded) {
            isScreenLightOn = true
        }
    }
    
    // Méthodes voor is folded 
    fun fold() {
        isFolded = true
    }
    
    fun unfold() {
        isFolded = false
    }
}

fun main() {    
    // instance voor FoldablePhone
    val monSamsungPliable = FoldablePhone()
    
    // Test 1 : scherm niet geplooit antwoord fals
    monSamsungPliable.switchOn()
    monSamsungPliable.checkPhoneScreenLight() // scherm is off 
    
    // Test 2 : deplooi gsm antwoord true 
    monSamsungPliable.unfold()
    monSamsungPliable.switchOn()
    monSamsungPliable.checkPhoneScreenLight() // scherm is on 
    }