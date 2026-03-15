package com.hssinouimohamedamine.affirmationsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.hssinouimohamedamine.affirmationsapp.ui.theme.SuperheroesAppTheme

// Activité principale de l'application
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Activation du mode bord à bord
        enableEdgeToEdge()
        setContent {
            // Utilisation de mon thème personnalisé
            SuperheroesAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Chargement de l'écran des héros
                    HeroesScreen()
                }
            }
        }
    }
}