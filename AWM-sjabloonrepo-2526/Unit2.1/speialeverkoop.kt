fun main() { // hier testen we de invest bidders 
    // Instance de l'enchère gagnante (le collectionneur privé)
    val winningBid = Bid(5000, "Private Collector")
    
    // Appel de la fonction avec une enchère réelle
    println("Item A is sold at ${auctionPrice(winningBid, 2000)}.")
    
    // safe call elvis neemt recht 
    println("Item B is sold at ${auctionPrice(null, 3000)}.")
}

// step 1 properties var 
class Bid(val amount: Int, val bidder: String)

// step 2  bid is nullable niemand heeft nog geld we beginen met null

fun auctionPrice(bid: Bid?, minimumPrice: Int): Int {

    // tis nulable en de minimumwaarde kan nul zijn dus elvise notatie 
// eliv kijk naar links dus 5000 en stop hiermee 
    return bid?.amount ?: minimumPrice
}