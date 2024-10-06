package com.example.bcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bcompose.ui.theme.BComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GreetingText(
                        fmsg = "",
                        smsg = "",
                        tmsg = "",

                        modifier = Modifier.padding(innerPadding) // innerPadding...
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingText(fmsg: String,smsg: String,tmsg: String, modifier: Modifier = Modifier) {

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(16.dp)
    ) {

        Text(
            text = fmsg,
            fontSize = 24.sp,
            modifier = modifier.padding(16.dp)
        )
        Text(
            text = smsg,
            modifier = modifier.padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = tmsg,
            modifier = modifier.padding(16.dp),
        )
    }

}

@Composable
fun GreetingImg(fmsg: String, smsg: String, tmsg: String){

    val img = painterResource(R.drawable.composeimg1) // Ajouter une image.

    Column {
        Image(
            painter = img,
            contentDescription = null
        )

        GreetingText(
            fmsg = fmsg,
            smsg = smsg,
            tmsg = tmsg
        )
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    BComposeTheme {
        GreetingImg(
            fmsg = "Jetpack Compose tutorial\n",
            smsg = "\n" +
                    "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.\n",
            tmsg = "\n" +  "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app\\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\\'s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name."
        )
    }
}