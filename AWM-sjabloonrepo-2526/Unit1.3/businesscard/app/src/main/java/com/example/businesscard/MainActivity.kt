package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinesscardTheme

// THEORIE: Klassen (MainActivity) beginnen met een HOOFDLETTER. Dit is de motor van mijn scherm.
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // LAMBDA: De { } hieronder is een 'lambda parameter'. Alles hierbinnen wordt uitgevoerd door setContent.
        setContent {
            BusinesscardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), // MODIFIER: Hiermee bepaal ik HOE een element eruit ziet (hier: schermvullend).
                    color = Color(0xFF001F3F) // Mijn donkerblauwe kleur
                ) {
                    VisiteKaartje()
                }
            }
        }
    }
}

// THEORIE: Composables beginnen met een HOOFDLETTER. Dit zijn mijn eigen herbruikbare bouwblokken.
@Composable
fun VisiteKaartje() {
    // COLUMN: Dit gebruik ik om elementen VERTICAAL (onder elkaar) te stapelen.
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally, // Zet alles in het midden van links naar rechts
        verticalArrangement = Arrangement.SpaceAround // Verdeel de witruimte gelijkmatig over de hoogte
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // R.drawable: 'R' is de grote index van mijn app. 'drawable' is de map met mijn plaatjes.
            Image(
                painter = painterResource(id = R.drawable.android_logo), 
                contentDescription = "Logo",
                modifier = Modifier.size(120.dp) // Hier zet ik de afbeelding op 120dp bij 120dp
            )
            
            // KOTLIN: De taal die ik hier schrijf is Kotlin, ontwikkeld door JetBrains.
            Text(
                text = stringResource(R.string.user_full_name), // Haal tekst uit de 'strings' XML
                fontSize = 32.sp, // 'sp' gebruik ik altijd voor tekstgrootte
                color = Color.White
            )
            
            Text(
                text = stringResource(R.string.user_job_title),
                color = Color(0xFF00EEFF), // Mijn elektrische blauwe kleur
                fontSize = 18.sp,
                style = MaterialTheme.typography.labelLarge
            )
        }

        // ROW: Gebruik ik als ik elementen HORIZONTAAL (naast elkaar) wil zetten (zie ContactRij).
        Column(
            modifier = Modifier.padding(bottom = 50.dp)
        ) {
            ContactRij(Icons.Default.Phone, stringResource(R.string.user_phone))
            ContactRij(Icons.Default.Email, stringResource(R.string.user_email))
            ContactRij(Icons.Default.Share, stringResource(R.string.user_share))
        }
    }
}

// THEORIE: Variabelen (zoals 'icoon' en 'tekst') beginnen met een kleine letter (camelCase).
@Composable
fun ContactRij(icoon: ImageVector, tekst: String) {
    Row(
        modifier = Modifier.padding(8.dp).width(280.dp),
        verticalAlignment = Alignment.CenterVertically // Lijn het icoon en de tekst netjes uit op de middenlijn
    ) {
        Icon(
            imageVector = icoon,
            contentDescription = null,
            tint = Color(0xFF00EEFF),
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = tekst,
            color = Color.White,
            fontSize = 16.sp,
            modifier = Modifier.padding(start = 20.dp) // Maak ruimte tussen het icoon en de tekst
        )
    }
}

// ONTHOUDEN: 
// 1. Modifier = Hoe het eruit ziet. 
// 2. Column/Row = Waar het staat. 
// 3. R. = Toegang tot mijn bestanden (res).
// 4. Lambda { } = De inhoud van een functie doorgeven.
@Preview(showBackground = true)
@Composable
fun KaartjePreview() {
    BusinesscardTheme {
        Surface(color = Color(0xFF001F3F)) {
            VisiteKaartje()
        }
    }
}
