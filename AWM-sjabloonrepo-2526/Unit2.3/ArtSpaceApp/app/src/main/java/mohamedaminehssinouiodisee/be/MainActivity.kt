package mohamedaminehssinouiodisee.be

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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

@Composable
fun MijnPersoonlijkeGalerij(modifier: Modifier = Modifier) {
    val pic1 = R.drawable.rs6
    val pic2 = R.drawable.rs5
    val pic3 = R.drawable.rs4
    val pic4 = R.drawable.rs3
    val pic5 = R.drawable.s3

    var actueelBeeld by remember { mutableIntStateOf(pic1) }
    var titelReferentie by remember { mutableIntStateOf(R.string.rs6) }
    var jaarReferentie by remember { mutableIntStateOf(R.string.rs6_year) }
    var beschrijvingReferentie by remember { mutableIntStateOf(R.string.rs6_desc) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // De afbeelding in een kader met schaduw
        Box(
            modifier = Modifier
                .shadow(elevation = 10.dp, shape = RoundedCornerShape(4.dp))
                .border(2.dp, Color.White, RoundedCornerShape(4.dp))
                .background(Color.White)
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(actueelBeeld),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .aspectRatio(1.5f), // Aangepast voor auto's (breedbeeld)
                contentScale = ContentScale.Fit
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Informatie blok met een lichtgrijze achtergrond
        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = colorResource(id = R.color.white).copy(alpha = 0.9f),
            tonalElevation = 4.dp,
            shape = RoundedCornerShape(8.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = titelReferentie),
                    fontSize = 28.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = colorResource(id = R.color.hoofd_titel)
                )
                Text(
                    text = stringResource(id = beschrijvingReferentie),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Gray
                )
                Text(
                    text = "Modeljaar: ${stringResource(id = jaarReferentie)}",
                    fontSize = 18.sp,
                    fontStyle = FontStyle.Italic,
                    color = colorResource(id = R.color.sub_tekst)
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Knoppen met de gevraagde kleuren (Rood en Groen)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = {
                    when (actueelBeeld) {
                        pic1 -> { 
                            actueelBeeld = pic5
                            titelReferentie = R.string.s3
                            jaarReferentie = R.string.s3_year
                            beschrijvingReferentie = R.string.s3_desc
                        }
                        pic2 -> { 
                            actueelBeeld = pic1
                            titelReferentie = R.string.rs6
                            jaarReferentie = R.string.rs6_year
                            beschrijvingReferentie = R.string.rs6_desc
                        }
                        pic3 -> { 
                            actueelBeeld = pic2
                            titelReferentie = R.string.rs5
                            jaarReferentie = R.string.rs5_year
                            beschrijvingReferentie = R.string.rs5_desc
                        }
                        pic4 -> { 
                            actueelBeeld = pic3
                            titelReferentie = R.string.rs4
                            jaarReferentie = R.string.rs4_year
                            beschrijvingReferentie = R.string.rs4_desc
                        }
                        else -> { 
                            actueelBeeld = pic4
                            titelReferentie = R.string.rs3
                            jaarReferentie = R.string.rs3_year
                            beschrijvingReferentie = R.string.rs3_desc
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.knop_vorige_rood)),
                modifier = Modifier.width(130.dp)
            ) {
                Text("Vorige", color = Color.White, fontWeight = FontWeight.Bold)
            }

            Button(
                onClick = {
                    when (actueelBeeld) {
                        pic1 -> { 
                            actueelBeeld = pic2
                            titelReferentie = R.string.rs5
                            jaarReferentie = R.string.rs5_year
                            beschrijvingReferentie = R.string.rs5_desc
                        }
                        pic2 -> { 
                            actueelBeeld = pic3
                            titelReferentie = R.string.rs4
                            jaarReferentie = R.string.rs4_year
                            beschrijvingReferentie = R.string.rs4_desc
                        }
                        pic3 -> { 
                            actueelBeeld = pic4
                            titelReferentie = R.string.rs3
                            jaarReferentie = R.string.rs3_year
                            beschrijvingReferentie = R.string.rs3_desc
                        }
                        pic4 -> { 
                            actueelBeeld = pic5
                            titelReferentie = R.string.s3
                            jaarReferentie = R.string.s3_year
                            beschrijvingReferentie = R.string.s3_desc
                        }
                        else -> { 
                            actueelBeeld = pic1
                            titelReferentie = R.string.rs6
                            jaarReferentie = R.string.rs6_year
                            beschrijvingReferentie = R.string.rs6_desc
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.knop_volgende_groen)),
                modifier = Modifier.width(130.dp)
            ) {
                Text("Volgende", color = Color.White, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MijnPreview() {
    ArtSpaceAppTheme {
        MijnPersoonlijkeGalerij()
    }
}
