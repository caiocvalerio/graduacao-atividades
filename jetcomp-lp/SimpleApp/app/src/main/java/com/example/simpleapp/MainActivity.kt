package com.example.simpleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.simpleapp.ui.theme.SimpleAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleAppTheme {
                // A surface container using the 'background' color from the theme

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Screen()
                }
            }
        }
    }
}

@Composable
fun Screen() {

    val buttonState = remember {
        mutableStateOf(false)
    }
    Surface (
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()) {
        Card(
            modifier = Modifier
                .background(color = Color.White)
                .width(200.dp)
                .height(390.dp)
                .padding(12.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            GenerateHeader()
            GenerateBodyInfo(buttonState)
            Divider()
            Column(
                modifier = Modifier
                    .background(colorResource(R.color.black_001))
                    .width(400.dp)
                    .fillMaxHeight()
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text(modifier = Modifier.padding(10.dp),
                    text = stringResource(R.string.footer_msg),
                    color = colorResource(R.color.white),
                    textAlign = TextAlign.Center)
                Text(modifier = Modifier.width(350.dp),
                    text = "- " + stringResource(R.string.paola),
                    color = colorResource(R.color.white),
                    textAlign = TextAlign.End)
            }
        }
    }
}

@Composable
private fun GenerateBodyButton(buttonState: MutableState<Boolean>) {
    Button(
        onClick = {
            buttonState.value = !buttonState.value
        },
        modifier = Modifier.padding(15.dp),
        colors = ButtonDefaults.buttonColors(colorResource(R.color.fire))
    ) {
        Text(
            "Ingredients",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.White
        )
    }
    if (buttonState.value) {
        ButtonContent()
    } else {
        Box {/* hide button content */ }
    }
}


@Composable
private fun GenerateBodyInfo(buttonState: MutableState<Boolean>) {
    Column(
        modifier = Modifier.width(400.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(modifier = Modifier.padding(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = stringResource(R.string.recipe_name),
                style = MaterialTheme.typography.displaySmall,
                color = Color(red = 0, green = 0, blue = 0)
            )
            Text(
                text = stringResource(R.string.author_name),
                modifier = Modifier.padding(3.dp),
                style = MaterialTheme.typography.titleLarge,
                color = Color(169, 169, 169)
            )

            GenerateBodyButton(buttonState)
            Divider(modifier = Modifier.width(250.dp))

        }
        Column(modifier = Modifier.padding(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(5.dp)) {

            Text(
                text = stringResource(R.string.how_to_prepare),
                modifier = Modifier.padding(3.dp),
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
            Text(text = stringResource(R.string.recipe_stuffed_potato),
                modifier = Modifier.padding(3.dp),
                style = MaterialTheme.typography.bodyLarge,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Light,
                color = Color.Black,
                textAlign = TextAlign.Start)
        }
    }
}

@Composable
private fun GenerateHeader() {
    Column(
        modifier = Modifier
            .background(colorResource(R.color.black_001))
            .width(400.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,

    )
    {
        CreateImageProfile(painter = painterResource(R.drawable.potato))
        Divider()
    }
}

@Composable
private fun CreateImageProfile(modifier: Modifier = Modifier, painter: Painter) {
    Surface(
        modifier = modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        shadowElevation = 4.dp,
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
    ) {
        Image(
            painter = painter,
            contentDescription = "Profile Image",
            modifier = modifier.size(130.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Preview
@Composable
fun ButtonContent() {

    Box (
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(5.dp)
    ){
        Surface (
            modifier = Modifier
                .padding(3.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
            shape = RoundedCornerShape(corner = CornerSize(6.dp)),
            border = BorderStroke(width = 2.dp, color = Color.LightGray)
        ) {
            Ingredients(CardInfo)
        }
    }
}

@Composable
fun Ingredients(card: CardInfo) {
    if (card.checkCardInfoIntegrity()){
        LazyColumn (modifier = Modifier.background(Color.White)){
            var desc = card.desc.listIterator()
            var img = card.img.listIterator()
            items(card.name) {
                    item -> Card (
                modifier = Modifier
                        .padding(13.dp)
                        .fillMaxWidth(),
                shape = RectangleShape,
                colors = CardDefaults.cardColors(containerColor = colorResource(R.color.white)),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .background(colorResource(R.color.white))
                        .fillMaxWidth()
                        .padding(7.dp)

                ) {
                    CreateImageProfile(modifier = Modifier.size(100.dp),
                        painter = painterResource(img.next()))
                    Column(
                        modifier = Modifier
                            .padding(7.dp)
                            .align(alignment = Alignment.CenterVertically)
                    ) {
                        Text(
                            text = item,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        Text(
                            text = desc.next(),
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.DarkGray
                        )
                    }
                }
                if(!img.hasNext() && !desc.hasNext()){
                    desc = card.desc.listIterator()
                    img = card.img.listIterator()
                }
                    }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SimpleAppTheme {
        Screen()
    }
}