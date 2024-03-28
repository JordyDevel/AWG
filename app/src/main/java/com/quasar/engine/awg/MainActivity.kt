package com.quasar.engine.awg

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.quasar.engine.awg.ui.theme.AWGTheme
import com.quasar.engine.libawg.AWGCalibrator
import com.quasar.engine.libawg.AWGCalibres
import com.quasar.engine.libawg.Metal

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var calibre: AWGCalibrator?

        setContent {
            AWGTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainView(modifier = Modifier.fillMaxSize()) { awgCalibrator ->
                        calibre = awgCalibrator
                        return@MainView calibre?.compute() ?: AWGCalibres.awg_0000
                    }
                }
            }
        }
    }
}

@Composable
fun MainView(modifier: Modifier = Modifier, compute: (awgCalibrator: AWGCalibrator) -> AWGCalibres) {

    var maxTemperature by rememberSaveable { mutableStateOf("") }
    var wireLength by rememberSaveable { mutableStateOf("") }
    var voltage by rememberSaveable { mutableStateOf("") }
    var maxPower by rememberSaveable { mutableStateOf("") }
    var awgCalibre by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = modifier
            .padding(35.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.ic_launcher_playstore), contentDescription = "")

        Spacer(modifier = Modifier.padding(15.dp))

        Text(text = "Calcula el calibre mínimo para cargas en una línea de corriente directa")

        Spacer(modifier = Modifier.padding(15.dp))

        TextField(
            value = maxPower,
            onValueChange = { maxPower = it },
            label = { Text(text = "Potencia de trabajo (W)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true
        )

        Spacer(modifier = Modifier.padding(15.dp))

        TextField(
            value = voltage,
            onValueChange = { voltage = it },
            label = { Text(text = "Voltage de línea (V)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true
        )

        Spacer(modifier = Modifier.padding(15.dp))

        TextField(
            value = maxTemperature,
            onValueChange = { maxTemperature = it },
            label = { Text(text = "Temperatura máxima (°C)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true
        )

        Spacer(modifier = Modifier.padding(15.dp))

        TextField(
            value = wireLength,
            onValueChange = { wireLength = it },
            label = { Text(text = "Longitud del cable (m)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true
        )

        Spacer(modifier = Modifier.padding(15.dp))

        Button(onClick = {
            try {
                awgCalibre = compute(
                    AWGCalibrator(
                        Metal.CUPPER,
                        maxTemperature.toFloat(),
                        wireLength.toFloat(),
                        voltage.toFloat(),
                        maxPower.toFloat()
                    )
                )
                    .name
            } catch (e: Exception) {
                e.localizedMessage?.let { Log.w("Try", it) }
            }
        }) {
            Text(text = "Calcular")
        }

        Spacer(modifier = Modifier.padding(15.dp))

        Text(buildAnnotatedString {
            withStyle(style = SpanStyle(fontWeight = FontWeight.Normal)) {
                append("Se sugiere el uso de un cable de un sólo núcleo ")
            }
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp)) {
                append(awgCalibre)
            }
        })

        Spacer(modifier = Modifier.padding(15.dp))

        Text(text = "La información presentada es únicamente informativa", fontSize = 9.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun MainViewPreview() {
    AWGTheme {
        MainView { _ ->
            return@MainView AWGCalibres.awg_0000
        }
    }
}