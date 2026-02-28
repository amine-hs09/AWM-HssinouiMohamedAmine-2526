package mohamedaminehssinouiodisee.be

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import mohamedaminehssinouiodisee.be.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                MijnMaterial3Galerij()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MijnMaterial3Galerij() {
    val pic1 = R.drawable.rs6
    val pic2 = R.drawable.rs5
    val pic3 = R.drawable.rs4
    val pic4 = R.drawable.rs3
    val pic5 = R.drawable.s3

    var actueelBeeld by remember { mutableIntStateOf(pic1) }
    var titelReferentie by remember { mutableIntStateOf(R.string.rs6) }
    var jaarReferentie by remember { mutableIntStateOf(R.string.rs6_year) }
    var beschrijvingReferentie by remember { mutableIntStateOf(R.string.rs6_desc) }

    // Detecteer de oriëntatie van het scherm
    val configuration = LocalConfiguration.current
    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Audi Art Space", fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { innerPadding ->
        if (isLandscape) {
            // Lay-out voor Landschapsmodus (Tablet / Groot scherm)
            Row(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .padding(24.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(32.dp, Alignment.CenterHorizontally)
            ) {
                // Linkerkant: De Foto
                Box(modifier = Modifier.weight(1.2f), contentAlignment = Alignment.Center) {
                    AutoFotoKaart(actueelBeeld)
                }

                // Rechterkant: Info en Knoppen
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    AutoInfoSectie(titelReferentie, beschrijvingReferentie, jaarReferentie)
                    Spacer(modifier = Modifier.height(32.dp))
                    KnoppenRij(
                        onVorige = {
                            // Vorige logica
                            when (actueelBeeld) {
                                pic1 -> { actueelBeeld = pic5; titelReferentie = R.string.s3; jaarReferentie = R.string.s3_year; beschrijvingReferentie = R.string.s3_desc }
                                pic2 -> { actueelBeeld = pic1; titelReferentie = R.string.rs6; jaarReferentie = R.string.rs6_year; beschrijvingReferentie = R.string.rs6_desc }
                                pic3 -> { actueelBeeld = pic2; titelReferentie = R.string.rs5; jaarReferentie = R.string.rs5_year; beschrijvingReferentie = R.string.rs5_desc }
                                pic4 -> { actueelBeeld = pic3; titelReferentie = R.string.rs4; jaarReferentie = R.string.rs4_year; beschrijvingReferentie = R.string.rs4_desc }
                                else -> { actueelBeeld = pic4; titelReferentie = R.string.rs3; jaarReferentie = R.string.rs3_year; beschrijvingReferentie = R.string.rs3_desc }
                            }
                        },
                        onVolgende = {
                            // Volgende logica
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
            // Lay-out voor Portretmodus (Standaard mobiel)
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .padding(24.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                AutoFotoKaart(actueelBeeld)
                Spacer(modifier = Modifier.height(32.dp))
                AutoInfoSectie(titelReferentie, beschrijvingReferentie, jaarReferentie)
                Spacer(modifier = Modifier.height(40.dp))
                KnoppenRij(
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
}

@Composable
fun AutoFotoKaart(@DrawableRes beeldRes: Int) {
    ElevatedCard(
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 12.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.elevatedCardColors(containerColor = Color.White)
    ) {
        Image(
            painter = painterResource(beeldRes),
            contentDescription = null,
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth()
                .aspectRatio(1.5f),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun AutoInfoSectie(@StringRes titel: Int, @StringRes beschrijving: Int, @StringRes jaar: Int) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.7f)
        )
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = titel),
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.ExtraBold,
                color = colorResource(id = R.color.hoofd_titel)
            )
            Text(
                text = stringResource(id = beschrijving),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Modeljaar: ${stringResource(id = jaar)}",
                style = MaterialTheme.typography.labelLarge,
                fontStyle = FontStyle.Italic,
                color = colorResource(id = R.color.sub_tekst)
            )
        }
    }
}

@Composable
fun KnoppenRij(onVorige: () -> Unit, onVolgende: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally)
    ) {
        Button(
            onClick = onVorige,
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.knop_vorige_rood)),
            modifier = Modifier.weight(1f).height(48.dp)
        ) {
            Text("Vorige", fontWeight = FontWeight.Bold)
        }

        Button(
            onClick = onVolgende,
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.knop_volgende_groen)),
            modifier = Modifier.weight(1f).height(48.dp)
        ) {
            Text("Volgende", fontWeight = FontWeight.Bold)
        }
    }
}

@Preview(showBackground = true, device = "spec:width=1280dp,height=800dp,orientation=landscape")
@Composable
fun LandscapePreview() {
    ArtSpaceAppTheme {
        MijnMaterial3Galerij()
    }
}

@Preview(showBackground = true)
@Composable
fun PortraitPreview() {
    ArtSpaceAppTheme {
        MijnMaterial3Galerij()
    }
}
