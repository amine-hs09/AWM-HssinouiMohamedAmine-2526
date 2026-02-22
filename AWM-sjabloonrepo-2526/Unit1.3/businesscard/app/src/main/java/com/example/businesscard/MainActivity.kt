package com.example.businesscard // Hier zeg ik dat dit bestand hoort bij mijn businesscard pakket

import android.os.Bundle // Ik importeer Bundle om data door te geven aan de activity
import androidx.activity.ComponentActivity // Ik gebruik dit als basis voor mijn scherm
import androidx.activity.compose.setContent // Hiermee kan ik mijn eigen design (Compose) op het scherm zetten
import androidx.compose.foundation.Image // Nodig om plaatjes te laten zien
import androidx.compose.foundation.layout.* // Om alles netjes op zijn plek te zetten (zoals marges en grootte)
import androidx.compose.material.icons.Icons // Ik gebruik de standaard icoontjes van Google
import androidx.compose.material.icons.filled.Email // Specifiek icoontje voor e-mail
import androidx.compose.material.icons.filled.Phone // Specifiek icoontje voor telefoon
import androidx.compose.material.icons.filled.Share // Specifiek icoontje voor delen
import androidx.compose.material3.Icon // Om de icoontjes daadwerkelijk te tekenen
import androidx.compose.material3.MaterialTheme // Voor de algemene stijl van de app
import androidx.compose.material3.Surface // Een basislaag waar ik alles op leg
import androidx.compose.material3.Text // Om tekst te kunnen schrijven
import androidx.compose.runtime.Composable // Zegt tegen Android dat dit een design-functie is
import androidx.compose.ui.Alignment // Om dingen in het midden of aan de kant te zetten
import androidx.compose.ui.Modifier // Mijn gereedschapskist om elementen aan te passen (grootte, kleur, etc.)
import androidx.compose.ui.graphics.Color // Om kleuren te kiezen
import androidx.compose.ui.graphics.vector.ImageVector // Type voor mijn icoontjes
import androidx.compose.ui.res.painterResource // Om plaatjes uit mijn mapje 'res' te laden
import androidx.compose.ui.res.stringResource // Om tekst uit mijn 'strings.xml' te halen
import androidx.compose.ui.tooling.preview.Preview // Zodat ik het design kan zien in Android Studio
import androidx.compose.ui.unit.dp // Maateenheid voor afstand
import androidx.compose.ui.unit.sp // Maateenheid voor tekstgrootte
import com.example.businesscard.ui.theme.BusinesscardTheme // Mijn eigen thema voor de app

class MainActivity : ComponentActivity() { // Dit is de 'motor' van mijn app-scherm
    override fun onCreate(savedInstanceState: Bundle?) { // Dit gebeurt er als de app opstart
        super.onCreate(savedInstanceState) // Start de standaard dingen van Android op
        setContent { // Hier begin ik mijn design te bouwen
            BusinesscardTheme { // Ik pas mijn eigen kleuren en stijl toe
                Surface( // Ik maak een achtergrondvlak
                    modifier = Modifier.fillMaxSize(), // Het moet het hele scherm vullen
                    color = Color(0xFF001F3F) // Ik kies een hele donkerblauwe kleur
                ) {
                    VisiteKaartje() // Ik roep mijn functie aan die het kaartje tekent
                }
            }
        }
    }
}

@Composable // Dit is een stukje van mijn design
fun VisiteKaartje() {
    Column( // Ik zet alles netjes onder elkaar
        modifier = Modifier.fillMaxSize(), // Vul het hele scherm
        horizontalAlignment = Alignment.CenterHorizontally, // Alles in het midden van links naar rechts
        verticalArrangement = Arrangement.SpaceAround // Verdeel de ruimte mooi tussen boven en onder
    ) {
        Column( // Een aparte kolom voor mijn naam en logo
            horizontalAlignment = Alignment.CenterHorizontally // Alles in het midden zetten
        ) {
            Image( // Hier toon ik mijn logo
                painter = painterResource(id = R.drawable.android_logo), // Pak het android_logo plaatje
                contentDescription = "Android Logo", // Voor blinden die de app gebruiken
                modifier = Modifier // Ik pas het plaatje aan
                    .height(120.dp) // 120 hoog maken
                    .width(120.dp) // 120 breed maken
            )
            Text( // Mijn naam op het scherm
                text = stringResource(R.string.user_full_name), // Haal Amine Hssinoui uit strings.xml
                fontSize = 32.sp, // Lekker grote letters
                color = Color.White // Witte kleur voor mijn naam
            )
            Text( // Mijn functie onder mijn naam
                text = stringResource(R.string.user_job_title), // Haal de functie uit strings.xml
                color = Color(0xFF00EEFF), // Dit is mijn 'elektrisch blauwe' kleur!
                fontSize = 18.sp, // Iets kleinere letters
                style = MaterialTheme.typography.labelLarge // Een mooie dikke stijl
            )
        }

        Column( // Een aparte kolom voor mijn contactgegevens onderaan
            modifier = Modifier.padding(bottom = 50.dp) // Een beetje ruimte van de onderkant
        ) {
            ContactRij( // Rij voor mijn telefoonnummer
                icoon = Icons.Default.Phone, // Gebruik het telefoon-icoon
                tekst = stringResource(R.string.user_phone) // Haal nummer uit strings.xml
            )
            ContactRij( // Rij voor mijn mail
                icoon = Icons.Default.Email, // Gebruik het mail-icoon
                tekst = stringResource(R.string.user_email) // Haal mail uit strings.xml
            )
            ContactRij( // Rij voor mijn share info
                icoon = Icons.Default.Share, // Gebruik het share-icoon
                tekst = stringResource(R.string.user_share) // Haal de link uit strings.xml
            )
        }
    }
}

@Composable // Een hulpfunctie om een rij met een icoon en tekst te maken
fun ContactRij(icoon: ImageVector, tekst: String) {
    Row( // Zet icoon en tekst naast elkaar
        modifier = Modifier // Aanpassingen aan de rij
            .padding(8.dp) // Ruimte om de rij heen
            .width(280.dp), // Ik geef het een vaste breedte voor nette uitlijning
        verticalAlignment = Alignment.CenterVertically // Icoon en tekst op dezelfde hoogte zetten
    ) {
        Icon( // Teken het icoontje
            imageVector = icoon, // Welk icoontje? (doorgegeven via de functie)
            contentDescription = null, // Geen uitleg nodig voor screenreaders hier
            tint = Color(0xFF00EEFF), // Geef het icoon mijn elektrisch blauwe kleur
            modifier = Modifier.size(24.dp) // Maak het icoon 24 groot
        )
        Text( // De tekst naast het icoon
            text = tekst, // Welke tekst? (doorgegeven via de functie)
            color = Color.White, // Altijd witte tekst
            fontSize = 16.sp, // Normale grootte voor info
            modifier = Modifier.padding(start = 20.dp) // Ruimte tussen icoon en tekst
        )
    }
}

@Preview(showBackground = true) // Hiermee zie ik mijn kaartje direct in de editor
@Composable
fun KaartjePreview() {
    BusinesscardTheme { // Gebruik het thema ook in de preview
        Surface(color = Color(0xFF001F3F)) { // Met de blauwe achtergrond
            VisiteKaartje() // Laat het kaartje zien
        }
    }
}
