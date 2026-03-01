package mohamedaminehssinouiodisee.be

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mohamedaminehssinouiodisee.be.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Initiële compositie: Het aanmaken van de UI door Compose wanneer het voor de eerste keer wordt uitgevoerd
            ArtSpaceAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MijnPersoonlijkeGalerij()
                }
            }
        }
    }
}

// Composable functies vormen de "Compositie": een beschrijving van de UI die door Compose wordt gemaakt
@Composable
fun MijnPersoonlijkeGalerij(modifier: Modifier = Modifier) {
    // Statische data (bronnen)
    val pic1 = R.drawable.rs6
    val pic2 = R.drawable.rs5
    val pic3 = R.drawable.rs4
    val pic4 = R.drawable.rs3
    val pic5 = R.drawable.s3

    /**
     * STATE: Iedere waarde die na verloop van tijd kan veranderen.
     * REMEMBER & MUTABLESTATEOF: Standaard is een Composable stateless (state wordt gereset bij recomposition).
     * We gebruiken 'remember' om de state te behouden over verschillende recompositions heen.
     */
    var actueelBeeld by remember { mutableIntStateOf(pic1) }
    var titelReferentie by remember { mutableIntStateOf(R.string.rs6) }
    var jaarReferentie by remember { mutableIntStateOf(R.string.rs6_year) }
    var beschrijvingReferentie by remember { mutableIntStateOf(R.string.rs6_desc) }

    // Configuratie state (verandert bij schermrotatie)
    val configuration = LocalConfiguration.current
    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

    if (isLandscape) {
        // Lay-out voor Landschap (Tablet / Horizontaal)
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(32.dp, Alignment.CenterHorizontally)
        ) {
            Box(modifier = Modifier.weight(1.2f), contentAlignment = Alignment.Center) {
                AutoFotoKader(actueelBeeld) // State wordt naar beneden doorgegeven
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                AutoInformatieBlok(titelReferentie, beschrijvingReferentie, jaarReferentie)
                Spacer(modifier = Modifier.height(32.dp))

                /**
                 * STATE HOISTING: Het verplaatsen van state naar een hogere plaats (hier).
                 * NavigatieKnoppen is hierdoor 'stateless' omdat we de state en events (onClick) doorgeven.
                 */
                NavigatieKnoppen(
                    onVorige = {
                        // HERSAMENSTELLING (RECOMPOSITION): Wanneer we deze waarden aanpassen,
                        // worden de Composables opnieuw uitgevoerd met de nieuwe gegevens.
                        when (actueelBeeld) {
                            pic1 -> { actueelBeeld = pic5; titelReferentie = R.string.s3; jaarReferentie = R.string.s3_year; beschrijvingReferentie = R.string.rs3_desc }
                            pic2 -> { actueelBeeld = pic1; titelReferentie = R.string.rs6; jaarReferentie = R.string.rs6_year; beschrijvingReferentie = R.string.rs6_desc }
                            pic3 -> { actueelBeeld = pic2; titelReferentie = R.string.rs5; jaarReferentie = R.string.rs5_year; beschrijvingReferentie = R.string.rs5_desc }
                            pic4 -> { actueelBeeld = pic3; titelReferentie = R.string.rs4; jaarReferentie = R.string.rs4_year; beschrijvingReferentie = R.string.rs4_desc }
                            else -> { actueelBeeld = pic4; titelReferentie = R.string.rs3; jaarReferentie = R.string.rs3_year; beschrijvingReferentie = R.string.rs3_desc }
                        }
                    },
                    onVolgende = {
                        when (actueelBeeld) {
                            pic1 -> { actueelBeeld = pic2; titelReferentie = R.string.rs5; jaarReferentie = R.string.rs5_year; beschrijvingReferentie = R.string.rs5_desc }
                            pic2 -> { actueelBeeld = pic3; titelReferentie = R.string.rs4; jaarReferentie = R.string.rs4_year; beschrijvingReferentie = R.string.rs4_desc }
                            pic3 -> { actueelBeeld = pic4; titelReferentie = R.string.rs3; jaarReferentie = R.string.rs3_year; beschrijvingReferentie = R.string.rs3_desc }
                            pic4 -> { actueelBeeld = pic5; titelReferentie = R.string.s3; jaarReferentie = R.string.s3_year; beschrijvingReferentie = R.string.s3_desc }
                            else -> { actueelBeeld = pic1; titelReferentie = R.string.rs6; jaarReferentie = R.string.rs6_year; beschrijvingReferentie = R.string.rs6_desc }
                        }
                    }
                )
            }
        }
    } else {
        // Lay-out voor Portret (Mobiel / Verticaal)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            AutoFotoKader(actueelBeeld)
            Spacer(modifier = Modifier.height(32.dp))
            AutoInformatieBlok(titelReferentie, beschrijvingReferentie, jaarReferentie)
            Spacer(modifier = Modifier.height(40.dp))
            NavigatieKnoppen(
                onVorige = {
                    when (actueelBeeld) {
                        pic1 -> { actueelBeeld = pic5; titelReferentie = R.string.s3; jaarReferentie = R.string.s3_year; beschrijvingReferentie = R.string.s3_desc }
                        pic2 -> { actueelBeeld = pic1; titelReferentie = R.string.rs6; jaarReferentie = R.string.rs6_year; beschrijvingReferentie = R.string.rs6_desc }
                        pic3 -> { actueelBeeld = pic2; titelReferentie = R.string.rs5; jaarReferentie = R.string.rs5_year; beschrijvingReferentie = R.string.rs5_desc }
                        pic4 -> { actueelBeeld = pic3; titelReferentie = R.string.rs4; jaarReferentie = R.string.rs4_year; beschrijvingReferentie = R.string.rs4_desc }
                        else -> { actueelBeeld = pic4; titelReferentie = R.string.rs3; jaarReferentie = R.string.rs3_year; beschrijvingReferentie = R.string.rs3_desc }
                    }
                },
                onVolgende = {
                    when (actueelBeeld) {
                        pic1 -> { actueelBeeld = pic2; titelReferentie = R.string.rs5; jaarReferentie = R.string.rs5_year; beschrijvingReferentie = R.string.rs5_desc }
                        pic2 -> { actueelBeeld = pic3; titelReferentie = R.string.rs4; jaarReferentie = R.string.rs4_year; beschrijvingReferentie = R.string.rs4_desc }
                        pic3 -> { actueelBeeld = pic4; titelReferentie = R.string.rs3; jaarReferentie = R.string.rs3_year; beschrijvingReferentie = R.string.rs3_desc }
                        pic4 -> { actueelBeeld = pic5; titelReferentie = R.string.s3; jaarReferentie = R.string.s3_year; beschrijvingReferentie = R.string.s3_desc }
                        else -> { actueelBeeld = pic1; titelReferentie = R.string.rs6; jaarReferentie = R.string.rs6_year; beschrijvingReferentie = R.string.rs6_desc }
                    }
                }
            )
        }
    }
}

// Stateless Composable: ontvangt data via parameters (state hoisting principe)
@Composable
fun AutoFotoKader(@DrawableRes beeld: Int) {
    Box(
        modifier = Modifier
            .shadow(elevation = 10.dp, shape = RoundedCornerShape(4.dp))
            .border(2.dp, Color.White, RoundedCornerShape(4.dp))
            .background(Color.White)
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(beeld),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .aspectRatio(1.5f),
            contentScale = ContentScale.Fit
        )
    }
}

// Stateless Composable: beschrijft enkel de UI op basis van meegegeven strings
@Composable
fun AutoInformatieBlok(@StringRes titel: Int, @StringRes desc: Int, @StringRes jaar: Int) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color.White.copy(alpha = 0.9f),
        tonalElevation = 4.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = titel),
                fontSize = 28.sp,
                fontWeight = FontWeight.ExtraBold,
                color = colorResource(id = R.color.hoofd_titel)
            )
            Text(
                text = stringResource(id = desc),
                fontSize = 16.sp,
                color = Color.Gray
            )
            Text(
                text = "Modeljaar: ${stringResource(id = jaar)}",
                fontSize = 18.sp,
                fontStyle = FontStyle.Italic,
                color = colorResource(id = R.color.sub_tekst)
            )
        }
    }
}

// STATE HOISTING: Deze Composable is stateless. Hij krijgt events (onVorige/onVolgende) door van de parent.
@Composable
fun NavigatieKnoppen(onVorige: () -> Unit, onVolgende: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(
            onClick = onVorige, // Event wordt uitgevoerd in de parent (MijnPersoonlijkeGalerij)
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.knop_vorige_rood)),
            modifier = Modifier.width(130.dp)
        ) {
            Text("Vorige", color = Color.White, fontWeight = FontWeight.Bold)
        }

        Button(
            onClick = onVolgende, // Aanpassing van de state gebeurt 'hoger' in de boom
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.knop_volgende_groen)),
            modifier = Modifier.width(130.dp)
        ) {
            Text("Volgende", color = Color.White, fontWeight = FontWeight.Bold)
        }
    }
}

@Preview(showBackground = true, device = "spec:width=1280dp,height=800dp,orientation=landscape")
@Composable
fun LandscapePreview() {
    ArtSpaceAppTheme {
        MijnPersoonlijkeGalerij()
    }
}

@Preview(showBackground = true)
@Composable
fun PortraitPreview() {
    ArtSpaceAppTheme {
        MijnPersoonlijkeGalerij()
    }
}
