package com.hssinouimohamedamine.affirmationsapp

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hssinouimohamedamine.affirmationsapp.model.Hero
import com.hssinouimohamedamine.affirmationsapp.model.HeroesRepository
import com.hssinouimohamedamine.affirmationsapp.ui.theme.SuperheroesAppTheme

// Écran principal affichant la liste des héros
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroesScreen() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    // Titre de l'application
                    Text(
                        text = "Mes Super-héros",
                        style = MaterialTheme.typography.displayLarge
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        }
    ) { paddingValues ->
        // Liste déroulante des héros
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            items(HeroesRepository.heroes) { hero ->
                HeroItem(hero = hero)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

// Composant pour afficher un seul héros
@Composable
fun HeroItem(hero: Hero) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                // Nom du héros
                Text(
                    text = stringResource(id = hero.nameRes),
                    style = MaterialTheme.typography.displaySmall
                )
                Spacer(modifier = Modifier.height(8.dp))
                // Description du héros
                Text(
                    text = stringResource(id = hero.descriptionRes),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            // Image du héros
            Image(
                painter = painterResource(id = hero.imageRes),
                contentDescription = stringResource(id = hero.nameRes),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(72.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
        }
    }
}

// Aperçu de l'écran principal
@Preview
@Composable
fun HeroesScreenPreview() {
    SuperheroesAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            HeroesScreen()
        }
    }
}

// Aperçu en mode sombre
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HeroesScreenDarkPreview() {
    SuperheroesAppTheme(darkTheme = true) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            HeroesScreen()
        }
    }
}
