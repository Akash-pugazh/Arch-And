package com.pugazh.arch_apps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.pugazh.arch_apps.mvc.*
import com.pugazh.arch_apps.mvi.*
import com.pugazh.arch_apps.mvi.paired_devices.*
import com.pugazh.arch_apps.ui.theme.ArchAppsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArchAppsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
//                        val counterController = CounterController(CounterModel())
//                        CounterView(counterController)

                        val mviCounterViewModel = CounterViewModel()
                        CounterView(mviCounterViewModel)

                        val pairedDevicesViewModel = PairedDevicesViewModel()
                        PairedDevicesScreen(pairedDevicesViewModel)

                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArchAppsTheme {
        Greeting("Android")
    }
}