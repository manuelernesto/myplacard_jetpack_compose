package io.github.manuelernesto.myplacard_jetpackcompose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.layout.*
import androidx.ui.material.Button
import androidx.ui.material.Scaffold
import androidx.ui.material.TopAppBar
import androidx.ui.res.imageResource
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import androidx.ui.unit.sp
import io.github.manuelernesto.myplacard_jetpackcompose.ui.ComposeTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                Top()
            }
        }
    }
}

@Composable
fun App(team: Team) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        val counterState = state { 0 }
        Row(
            modifier = Modifier.fillMaxWidth().wrapContentSize(Alignment.TopCenter)
        ) {

            TeamItem(
                team = team.homeTeam,
                score = team.homeScore,
                img = team.homeLogo,
                onUpdate = { newScore ->
                    team.homeScore = newScore
                })

            TeamItem(
                team = team.guestTeam,
                score = team.guestScore,
                img = team.guestLogo,
                onUpdate = { newScore ->
                    team.guestScore = newScore
                })
        }
        Button(
            onClick = {
                team.homeScore = 0
                team.guestScore = 0
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                "Clean",
                fontSize = 18.sp,
                modifier = Modifier.wrapContentWidth(Alignment.CenterHorizontally)
            )
        }
    }

}

@Composable
fun Top() {
    Scaffold(
        topAppBar = {
            TopAppBar(
                title = {Text(text = "My Placard ")}
            )
        },
        bodyContent = {
            App(team = Team(
                    "Chigado",
                    0,
                    R.drawable.chicago,
                    "Lakers",
                    0,
                    R.drawable.lakers
                )
            )
        }
    )
}

@Composable
fun TeamItem(
    team: String,
    score: Int,
    img: Int,
    onUpdate: (Int) -> Unit
) {

    val imgResource = imageResource(img)
    Column(modifier = Modifier.padding(8.dp),
        horizontalGravity = Alignment.CenterHorizontally
    )
    {
        Text(text = "Home Team", fontSize = 20.sp)
        Spacer(Modifier.preferredHeight(16.dp))
        Image(imgResource, modifier = Modifier.preferredHeight(100.dp).preferredWidth(100.dp))
        Spacer(Modifier.preferredHeight(16.dp))
        Text(text = team, fontSize = 30.sp)
        Spacer(Modifier.preferredHeight(16.dp))
        Text(text = "$score", fontSize = 60.sp)
        Spacer(Modifier.preferredHeight(16.dp))
        Button(onClick = { onUpdate(score + 3) }) { Text("+ 3 points", fontSize = 18.sp) }
        Spacer(Modifier.preferredHeight(16.dp))
        Button(onClick = { onUpdate(score + 2) }) { Text("+ 2 points", fontSize = 18.sp) }
        Spacer(Modifier.preferredHeight(16.dp))
        Button(onClick = { onUpdate(score + 1) }) { Text("Free Throw", fontSize = 18.sp) }
        Spacer(Modifier.preferredHeight(16.dp))
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeTheme(darkTheme = false) {
        Top()
    }
}
