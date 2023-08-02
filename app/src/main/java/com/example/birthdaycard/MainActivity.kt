package com.example.birthdaycard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.birthdaycard.ui.theme.BirthdayCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BirthdayCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingText(notification = "Yo, It's your birthday",
                        message = "Rise and Shine, babe",
                        from = "bvuongle")
                }
            }
        }
    }
}

@Composable
fun GreetingText(notification: String, message: String, from: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier.padding(4.dp)
    ) {
        Text(
            text = notification,
            fontSize = 75.sp,
            textAlign = TextAlign.Center,
            lineHeight = 80.sp
        )
        Text(
            text = message,
            fontSize = 50.sp,
            textAlign = TextAlign.Center,
            lineHeight = 55.sp
        )
        Text(
            text = "From $from",
            fontSize = 30.sp,
            lineHeight = 35.sp,
            modifier = modifier.padding(16.dp).align(alignment = Alignment.End)
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun BirthdayCardPreview() {
    BirthdayCardTheme {
        GreetingText(
            notification = "Yooo, It's your birthday",
            message = "Rise and Shine, babe",
            from = "bvuongle"
        )
    }
}