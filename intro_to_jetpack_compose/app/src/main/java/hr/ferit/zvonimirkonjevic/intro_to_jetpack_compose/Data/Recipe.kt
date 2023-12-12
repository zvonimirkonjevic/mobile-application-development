package hr.ferit.zvonimirkonjevic.intro_to_jetpack_compose.Data

import androidx.annotation.DrawableRes
import hr.ferit.zvonimirkonjevic.intro_to_jetpack_compose.R

data class Recipe(
    var id: String = "",
    val image: String = "",
    val title: String = "",
    val category: String = "",
    val cookingTime: String = "",
    val energy: String = "",
    val rating: String = "",
    val description: String = "",
    val reviews: String = "",
    val ingredients: List<Ingredient> = listOf(),
    var isFavorited: Boolean = false
)