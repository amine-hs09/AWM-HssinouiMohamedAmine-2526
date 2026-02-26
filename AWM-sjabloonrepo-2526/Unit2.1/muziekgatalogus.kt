fun main() {    
   //ik maak hier een instance voor het muziek van gims , _ te herkennen 
     val gimsSong = Song("Sapés comme jamais", "Maître Gims", 2015, 500_000_000)
    
    // call mijn methode van beneden om de titel te laten zien 
    gimsSong.printDescription()
    
    // gebruik propertie van de getter  om te weten als het en hit is of niet 
    if (gimsSong.isPopular) {
        println("Cette chanson est un hit !")
    } else {
        println("Cette chanson est peu connue.")
    }
}

// mijn val 
class Song(
    val title: String, 
    val artist: String, 
    val yearPublished: Int, 
    val playCount: Int
) {
    // getter voor populariteit te verkeren 
    val isPopular: Boolean
        get() = playCount >= 1000

    // Méthode voor het bericht te schriven 
    fun printDescription() {
        println("$title, performed by $artist, was released in $yearPublished.")
    }   
}