package hr.ferit.zvonimirkonjevic.intro_to_jetpack_compose.Data

import androidx.annotation.DrawableRes

data class Ingredient (
    @DrawableRes val image: Int,
    var name: String = "",
    var subtitle: String = ""
)