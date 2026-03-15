package com.hssinouimohamedamine.affirmationsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hssinouimohamedamine.affirmationsapp.data.Car
import com.hssinouimohamedamine.affirmationsapp.data.CarsRepository
import com.hssinouimohamedamine.affirmationsapp.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // AppTheme : Définit les couleurs, la police et les formes de toute l'application
            AppTheme {
                // Surface : Le conteneur de base qui gère la couleur de fond
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CarsApp()
                }
            }
        }
    }
}

@Composable
fun CarsApp() {
    // Scaffold : Structure de base de l'écran (TopBar, BottomBar, Content)
    Scaffold(
        topBar = {
            CarsTopAppBar()
        }
    ) { paddingValues ->
        // LazyColumn : Liste performante qui ne charge que ce qui est visible à l'écran
        LazyColumn(contentPadding = paddingValues) {
            // items : Boucle sur la liste de données pour créer chaque élément
            items(CarsRepository.cars) { car ->
                CarItem(
                    car = car,
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarsTopAppBar(modifier: Modifier = Modifier){
    CenterAlignedTopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Filled.DirectionsCar,
                    contentDescription = null,
                    modifier = Modifier.size(32.dp).padding(end = 8.dp),
                    // tint : Applique une couleur à l'icône (ici onPrimary = blanc ou noir selon le thème)
                    tint = MaterialTheme.colorScheme.onPrimary
                )
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayLarge,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            // containerColor : Définit la couleur de fond de la TopBar
            containerColor = MaterialTheme.colorScheme.primary
        ),
        modifier = modifier
    )
}

@Composable
fun CarItem(
    car: Car,
    modifier: Modifier = Modifier
) {
    // remember + mutableStateOf : Garde en mémoire si la carte est ouverte ou fermée
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                // animateContentSize : Anime automatiquement le changement de taille (ouverture/fermeture)
                .animateContentSize(
                    // spring : Définit le style de l'animation (ici "ressort" sans rebond)
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_small))
            ) {
                CarIcon(car.imageRes)
                CarInformation(car.dayRes, car.nameRes)
                // Spacer + weight(1f) : Pousse tout ce qui suit vers la droite (le bouton)
                Spacer(Modifier.weight(1f))
                CarItemButton(
                    expanded = expanded,
                    onClick = { expanded = !expanded },
                )
            }
            // Condition if (expanded) : Affiche la description seulement si expanded est vrai
            if (expanded) {
                CarDescription(
                    car.descriptionRes,
                    modifier = Modifier.padding(
                        start = dimensionResource(R.dimen.padding_medium),
                        top = dimensionResource(R.dimen.padding_small),
                        end = dimensionResource(R.dimen.padding_medium),
                        bottom = dimensionResource(R.dimen.padding_medium)
                    )
                )
            }
        }
    }
}

@Composable
private fun CarItemButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            // Change l'icône selon l'état expanded (Flèche haut ou bas)
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            contentDescription = null,
            // tint : Applique une couleur (ici la couleur secondaire / Rouge AMG)
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}

@Composable
fun CarDescription(
    @StringRes carDesc: Int,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(R.string.about),
            style = MaterialTheme.typography.labelSmall
        )
        Text(
            text = stringResource(carDesc),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Composable
fun CarIcon(
    @DrawableRes carIcon: Int,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier
            .size(64.dp)
            .padding(dimensionResource(id = R.dimen.padding_small))
            // clip : Découpe l'image (arrondit les bords) selon les formes du thème
            .clip(MaterialTheme.shapes.small),
        painter = painterResource(carIcon),
        // ContentScale.Crop : Recadre l'image pour remplir le cadre sans la déformer (indispensable !)
        contentScale = ContentScale.Crop,
        contentDescription = null
    )
}

@Composable
fun CarInformation(
    @StringRes carDay: Int,
    @StringRes carName: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(carDay),
            style = MaterialTheme.typography.displayMedium,
            // color : Utilise la couleur secondaire (Rouge AMG) pour le jour
            color = MaterialTheme.colorScheme.secondary
        )
        Text(
            text = stringResource(carName),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview
@Composable
fun CarsPreview() {
    AppTheme {
        CarsApp()
    }
}
