package com.hssinouimohamedamine.affirmationsapp


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hssinouimohamedamine.affirmationsapp.R
import com.hssinouimohamedamine.affirmationsapp.data.Affirmations
import com.hssinouimohamedamine.affirmationsapp.data.Datasource
import com.hssinouimohamedamine.affirmationsapp.ui.theme.AffirmationsappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AffirmationsappTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AffirmationsApp()
                }
            }
        }
    }
}


@Composable
/**
 * Affiche une carte d'affirmation avec une image et un texte.
 * @param affirmation L'objet de données contenant les IDs de ressources.
 */
fun AffirmationCard(affirmation: Affirmations, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Column {
            Image(
                painter = painterResource(affirmation.imageResourceId),
                contentDescription = stringResource(affirmation.stringResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                // Transforme l'ID de ressource R.string en texte réel
                text = LocalContext.current.getString(affirmation.stringResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

@Composable
/**
 * Affiche une liste déroulante de cartes d'affirmation.
 */
fun AffirmationList(affirmationList: List<Affirmations>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(affirmationList) { affirmation ->
            AffirmationCard(
                affirmation = affirmation,
                modifier = Modifier.padding(5.dp)
            )
        }
    }
}

@Composable
fun AffirmationsApp() {
    AffirmationList(
        affirmationList = Datasource().loadAffirmations()
    )
}

@Preview
@Composable
private fun AffirmationCardPreviewCard1() {
    AffirmationCard(Affirmations(R.string.affirmation1, R.drawable.image1))
}
//cv
@Preview
@Composable
private fun AffirmationCardPreviewCard2() {
    AffirmationCard(Affirmations(R.string.affirmation2, R.drawable.image2))
}

@Preview(showBackground = true)
@Composable
private fun AffirmationsAppPreview() {
    AffirmationsappTheme {
        AffirmationsApp()
    }
}