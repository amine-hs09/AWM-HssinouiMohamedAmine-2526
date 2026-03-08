package mohamedaminehssinouiodisee.ben

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mohamedaminehssinouiodisee.ben.ui.theme.CalculatorTheme
import java.text.NumberFormat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    EcranCalculateur()
                }
            }
        }
    }
}

@Composable
fun EcranCalculateur() {
    var saisieMontant by remember { mutableStateOf("") }
    var saisiePourcentage by remember { mutableStateOf("") }
    var arrondirLeTotal by remember { mutableStateOf(false) }

    val valeurMontant = saisieMontant.toDoubleOrNull() ?: 0.0
    val valeurPourcentage = saisiePourcentage.toDoubleOrNull() ?: 0.0
    val pourboireFinal = calculerLePourboire(valeurMontant, valeurPourcentage, arrondirLeTotal)

    Column(
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 40.dp)
            .verticalScroll(rememberScrollState())
            .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.calculate_tip),
            modifier = Modifier
                .padding(bottom = 16.dp, top = 40.dp)
                .align(alignment = Alignment.Start)
        )
        ChampDeSaisie(
            identifiantLabel = R.string.bill_amount,
            optionsClavier = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            valeurActuelle = saisieMontant,
            quandLaValeurChange = { saisieMontant = it },
            modifier = Modifier.padding(bottom = 32.dp).fillMaxWidth(),
        )
        ChampDeSaisie(
            identifiantLabel = R.string.how_was_the_service,
            optionsClavier = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            valeurActuelle = saisiePourcentage,
            quandLaValeurChange = { saisiePourcentage = it },
            modifier = Modifier.padding(bottom = 32.dp).fillMaxWidth(),
        )
        SectionArrondi(
            estCoche = arrondirLeTotal,
            changementCoche = { arrondirLeTotal = it },
            modifier = Modifier.padding(bottom = 32.dp)
        )
        Text(
            text = stringResource(R.string.tip_amount, pourboireFinal),
            style = MaterialTheme.typography.displaySmall
        )
        Spacer(modifier = Modifier.height(150.dp))
    }
}

@Composable
fun ChampDeSaisie(
    @StringRes identifiantLabel: Int,
    optionsClavier: KeyboardOptions,
    valeurActuelle: String,
    quandLaValeurChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = valeurActuelle,
        singleLine = true,
        modifier = modifier,
        onValueChange = quandLaValeurChange,
        label = { Text(stringResource(identifiantLabel)) },
        keyboardOptions = optionsClavier
    )
}

@Composable
fun SectionArrondi(
    estCoche: Boolean,
    changementCoche: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = stringResource(R.string.round_up_tip))
        Switch(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.End),
            checked = estCoche,
            onCheckedChange = changementCoche
        )
    }
}

private fun calculerLePourboire(montant: Double, pourcentage: Double = 15.0, doitArrondir: Boolean): String {
    var resultat = pourcentage / 100 * montant
    if (doitArrondir) {
        resultat = kotlin.math.ceil(resultat)
    }
    return NumberFormat.getCurrencyInstance().format(resultat)
}

@Preview(showBackground = true)
@Composable
fun EcranCalculateurPreview() {
    CalculatorTheme {
        EcranCalculateur()
    }
}
