package com.example.birthdaycard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
                    GreetingImage(
                        notification = stringResource(R.string.happy_birthday_text),
                        message = stringResource(R.string.msg_1),
                        from = stringResource(R.string.author_1)
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingText(notification: String, message: String, from: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
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
            lineHeight = 55.sp,
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = stringResource(R.string.from_msg, from),
            fontSize = 30.sp,
            lineHeight = 35.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.End)
        )
    }
}

@Composable
fun GreetingImage(notification: String, message: String, from: String, modifier: Modifier = Modifier) {
    Box(modifier) {
        Image(
            painter = painterResource(R.drawable.androidparty),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.75f
        )
        GreetingText(
            notification = notification,
            message = message,
            from = from,
            modifier = Modifier.align(alignment = Alignment.Center).padding(8.dp)
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
        GreetingImage(
            notification = stringResource(id = R.string.happy_birthday_text),
            message = stringResource(id = R.string.msg_1),
            from = stringResource(id = R.string.author_1)
        )
    }
}