package com.example.greetingcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.greetingcard.ui.theme.GreetingcardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GreetingcardTheme {
                // default van android studio
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    Greeting(
                        name = "Hssinoui Mohamed Amine", // mijn naam niet android studio
                        modifier = Modifier.padding(innerPadding) // is de padding
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    // het toevoegen van een color rond de modifier
    Surface(color = Color.Cyan) {
        Text(
            text = "Hi, my name is $name!", // naam
            modifier = modifier.padding(24.dp) // la marge
        )
    }
}
// das gewoon een previeuw
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GreetingcardTheme {

        Greeting("Hssinoui Mohamed Amine")
    }
}