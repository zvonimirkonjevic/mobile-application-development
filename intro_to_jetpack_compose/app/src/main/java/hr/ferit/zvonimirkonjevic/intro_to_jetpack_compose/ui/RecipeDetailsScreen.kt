package hr.ferit.zvonimirkonjevic.intro_to_jetpack_compose.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import hr.ferit.zvonimirkonjevic.intro_to_jetpack_compose.Data.Recipe
import hr.ferit.zvonimirkonjevic.intro_to_jetpack_compose.Data.recipes
import hr.ferit.zvonimirkonjevic.intro_to_jetpack_compose.R
import hr.ferit.zvonimirkonjevic.intro_to_jetpack_compose.ui.theme.DarkGray
import hr.ferit.zvonimirkonjevic.intro_to_jetpack_compose.ui.theme.LightGray
import hr.ferit.zvonimirkonjevic.intro_to_jetpack_compose.ui.theme.Pink
import hr.ferit.zvonimirkonjevic.intro_to_jetpack_compose.ui.theme.White

@Preview(showBackground = true)
@Composable
fun RecipeDetailsScreen() {
    val scrollState = rememberLazyListState()
    val recipe = recipes[0]

    LazyColumn(
        state = scrollState,
        modifier = Modifier.fillMaxSize(),
    ){
        item{
            TopImageAndBar(recipe.image)
            ScreenTitle(title = recipe.title, subtitle = recipe.category)
            BasicInfo(recipe = recipe)
            Description(recipe = recipe)
            Servings()
            IngredientsHeader()
            IngredientsList(recipe = recipe)
        }
    }
}

@Composable
fun TopImageAndBar(
    @DrawableRes coverImage: Int
) {
    Box(
        modifier = Modifier
            .height(300.dp)
            .fillMaxWidth()
    ){
        Image(
            painter = painterResource(id = coverImage),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                CircularButton(iconResource = R.drawable.ic_arrow_back, color = Pink)
                CircularButton(iconResource = R.drawable.ic_favorite)
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                White
                            ),
                            startY = 100f
                        )
                    )
            )
        }
    }
}

@Composable
fun CircularButton(
    @DrawableRes iconResource: Int,
    elevation: ButtonElevation? = ButtonDefaults.buttonElevation(12.dp),
    color: Color = DarkGray,
    onClick: () -> Unit = {}
) {
    Button(
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(containerColor = White, contentColor = color),
        elevation = elevation,
        onClick = onClick,
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .width(38.dp)
            .height(38.dp)
        ){
        Icon(painter = painterResource(id = iconResource), contentDescription = null)
    }
}

@Composable
fun InfoColumn(
    @DrawableRes iconResource: Int,
    text: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = iconResource),
            contentDescription = null,
            tint = Pink,
            modifier = Modifier.height(24.dp)
        )
        Text(text = text, fontWeight = FontWeight.Bold)
    }
}
@Composable
fun BasicInfo(recipe: Recipe) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        InfoColumn(R.drawable.ic_clock, recipe.cookingTime)
        InfoColumn(R.drawable.ic_flame, recipe.energy)
        InfoColumn(R.drawable.ic_star, recipe.rating)
    }
}

@Composable
fun Description(
    recipe: Recipe
) {
    Text(
        text = recipe.description,
        fontWeight = FontWeight.Medium,
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 20.dp)
    )
}

@Composable
fun Servings() {
    var value by remember {
        mutableStateOf(6)
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ){
        Text(
            text = "Servings",
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .weight(1f)
        )
        CircularButton(
            iconResource = R.drawable.ic_minus,
            color = Pink,
            elevation = null,
            ){
            value--
        }
        Text(
            text = "$value",
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .padding(horizontal = 20.dp)
        )
        CircularButton(
            iconResource = R.drawable.ic_plus,
            color = Pink,
            elevation = null,
        ){
            value++
        }
    }
}

@Composable
fun IngredientsHeader() {
    var activeButtonId by remember { mutableStateOf(0) }

    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .background(Color.Transparent)
            .fillMaxWidth()
            .height(44.dp)
    ){
        TabButton(
            text = "Ingredient",
            isActive = activeButtonId == 0,
            modifier = Modifier.weight(1f)
        ) {
            activeButtonId = 0
        }
        TabButton(
            text = "Tools",
            isActive = activeButtonId == 1,
            modifier = Modifier.weight(1f)
        ) {
            activeButtonId = 1
        }
        TabButton(
            text = "Steps",
            isActive = activeButtonId == 2,
            modifier = Modifier.weight(1f)
        ) {
            activeButtonId = 2
        }
    }
}

@Composable
fun <T> EasyGrid(nColumns: Int, items: List<T>, content: @Composable (T) -> Unit) {
    Column(Modifier.padding(16.dp)) {
        for (i in items.indices step nColumns) {
            Row {
                for (j in 0 until nColumns) {
                    if (i + j < items.size) {
                        Box(
                            contentAlignment = Alignment.TopCenter,
                            modifier = Modifier.weight(1f)
                        ) {
                            content(items[i + j])
                        }
                    } else {
                        Spacer(Modifier.weight(1f, fill = true))
                    }
                }
            }
        }
    }
}

@Composable
fun IngredientCard(
    @DrawableRes iconResource: Int,
    title: String,
    subtitle: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(bottom = 16.dp)
    ) {
        Card(
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor =  LightGray),
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .padding(8.dp)
        ){
            Image(
                painter = painterResource(id = iconResource), 
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            )
        }
        Text(
            text = title,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.width(100.dp)
        )
        Text(
            text = subtitle,
            color = DarkGray,
            fontSize = 14.sp,
            modifier = Modifier.width(100.dp)
        )
    }
}

@Composable
fun IngredientsList(
    recipe: Recipe
) {
    EasyGrid(nColumns = 3, items = recipe.ingredients) {
        IngredientCard(it.image, it.name, it.subtitle)
    }
}

@Composable
fun ShoppingListButton() {
    Button(
        onClick = { /*TODO*/ },
        elevation = null,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = Color.Black
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = "Add to shopping list", modifier =
        Modifier.padding(8.dp))
    }
}