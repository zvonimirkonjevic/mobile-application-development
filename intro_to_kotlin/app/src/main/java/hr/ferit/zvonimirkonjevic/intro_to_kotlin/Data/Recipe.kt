package hr.ferit.zvonimirkonjevic.intro_to_kotlin.Data

import androidx.annotation.DrawableRes

data class Recipe (
    @DrawableRes val image: Int = 0,
    var title: String = "",
    var category: String = "",
    var cookingTime: Int = 0,
    var energy: Int = 0,
    var rating: Int = 0,
    var description: String = "",
    var reviews: List<String>? = null,
    var ingredients: List<Ingredient>? = null
)