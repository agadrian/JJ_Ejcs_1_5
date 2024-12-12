package com.es.ejcs1_5_jj

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.es.ejcs1_5_jj.screens.Actividad1
import com.es.ejcs1_5_jj.screens.Actividad3
import com.es.ejcs1_5_jj.screens.Actividad4
import com.es.ejcs1_5_jj.screens.Actividad5
import com.es.ejcs1_5_jj.ui.theme.Ejcs1_5_JJTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ejcs1_5_JJTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Actividad5()
                }
            }
        }
    }
}
