package com.es.ejcs1_5_jj.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/*
Actividad 1:
Hacer que el texto del botón muestre "Cargar perfil", pero cambie a "Cancelar"
cuando se muestre la línea de progreso... Cuando pulsemos "Cancelar" vuelve al texto por defecto.
*/

@Composable
fun Actividad1() {
    var showLoading by rememberSaveable { mutableStateOf(false) }
    var texto by rememberSaveable { mutableStateOf("Cargar") }

    Column(
        Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (showLoading) {
            CircularProgressIndicator(
                color = Color.Red,
                strokeWidth = 10.dp
            )
            LinearProgressIndicator(
                modifier = Modifier.padding(top = 32.dp),
                color = Color.Red,
                trackColor = Color.LightGray
            )
        }

        Button(
            modifier = Modifier
                // Pading dependiente del estado de showLoading
                .padding(top = if (showLoading) 30.dp else 0.dp),
            onClick = {
                showLoading = !showLoading
                // Cambiar el texto dependiendo del estado de showLoading
                texto = if (showLoading) "Cancelar" else "Cargar"
            }
        ) {
            Text(text = texto)
        }
    }
}

/*
Actividad 2:
Modifica ahora también que se separe el botón de la línea de progreso 30 dp,
pero usando un estado... es decir, cuando no sea visible no quiero que tenga la separación
aunque no se vea.
*/

//
// **** Arriba en el 1 implementada ******


/*
Actividad 3:
- Separar los botones entre ellos 10 dp, del indicador de progreso 15 dp y centrarlos horizontalmente.
- Cuando se clique el botón Incrementar, debe añadir 0.1 a la propiedad progress y quitar 0.1
  cuando se pulse el botón Decrementar.
- Evitar que nos pasemos de los márgenes de su propiedad progressStatus (0-1)
*/
//@Preview(showBackground = true)
@Composable
fun Actividad3() {

    var progress by rememberSaveable { mutableStateOf(0f) }

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LinearProgressIndicator(progress = progress)

        Spacer(Modifier.height(15.dp))

        Row(
            Modifier
                .fillMaxWidth()
                ,
            horizontalArrangement = Arrangement.Center,


        ) {
            Button(
                modifier = Modifier
                    .padding(end = 10.dp),
                onClick = {
                    // Sumar 0.1 teniendo en cuanta el maximo
                    if (progress < 1f) progress += 0.1f
                }
            ) {
                Text(text = "Incrementar")
            }

            Button(
                onClick = {
                    //Restar 0.1 teniendo en cuenta el minimo
                    if (progress > 0) progress -= 0.1f

                }
            ) {
                Text(text = "Reducir")
            }
        }
    }
}


/*
Actividad 4:
Sitúa el TextField en el centro de la pantalla y haz que reemplace el valor de una coma por un punto
y que no deje escribir más de un punto decimal...
*/
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun Actividad4() {
    var myVal by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        TextField(
            value = myVal,
            onValueChange = {

                val nValor = it.replace(",", ".")

                if (nValor.count { char -> char == '.' } <= 1) {
                    myVal = nValor
                }
            },

            label = { Text(text = "Importe") }
        )
    }
}


/*
Actividad 5:
Haz lo mismo, pero elevando el estado a una función superior y usando un componente OutlinedTextField
al que debes añadir un padding alrededor de 15 dp y establecer colores diferentes en los bordes
cuando tenga el foco y no lo tenga.
A nivel funcional no permitas que se introduzcan caracteres que invaliden un número decimal.
*/
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Actividad5() {
    var myVal by rememberSaveable { mutableStateOf("") }

    Column(
        Modifier
            .fillMaxSize()
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        MyOutlinedTextField(
            myVal,
            onValChange = {
                myVal = it
            }
        )
    }
}

@Composable
fun MyOutlinedTextField(
    myVal: String,
    onValChange: (String) -> Unit
){
    OutlinedTextField(
        value = myVal,
        onValueChange = onValChange,
        label = { Text(text = "Importe") },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.Blue,
            unfocusedBorderColor = Color.Black
        )
    )
}