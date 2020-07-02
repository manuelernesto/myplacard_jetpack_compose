package io.github.manuelernesto.myplacard_jetpackcompose

import androidx.annotation.DrawableRes
import androidx.compose.*


@Model
class Team(
    val homeTeam: String,
    var homeScore: Int,
    @DrawableRes val homeLogo: Int,
    val guestTeam: String,
    var guestScore: Int,
    @DrawableRes val guestLogo: Int
) {
//    var homeScore by mutableStateOf(Int)
//    var guestScore by mutableStateOf(Int)

}