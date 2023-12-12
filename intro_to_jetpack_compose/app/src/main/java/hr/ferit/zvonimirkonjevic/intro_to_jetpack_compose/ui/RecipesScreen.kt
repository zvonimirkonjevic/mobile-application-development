package hr.ferit.zvonimirkonjevic.intro_to_jetpack_compose.ui

import android.icu.text.CaseMap
import android.icu.text.CaseMap.Title
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ScaleFactor
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import hr.ferit.zvonimirkonjevic.intro_to_jetpack_compose.Data.RecipeViewModel
import hr.ferit.zvonimirkonjevic.intro_to_jetpack_compose.R
import hr.ferit.zvonimirkonjevic.intro_to_jetpack_compose.Routes
import hr.ferit.zvonimirkonjevic.intro_to_jetpack_compose.ui.theme.DarkGray
import hr.ferit.zvonimirkonjevic.intro_to_jetpack_compose.ui.theme.LightGray
import hr.ferit.zvonimirkonjevic.intro_to_jetpack_compose.ui.theme.Pink
import hr.ferit.zvonimirkonjevic.intro_to_jetpack_compose.ui.theme.Purple200
import hr.ferit.zvonimirkonjevic.intro_to_jetpack_compose.ui.theme.Purple500
import hr.ferit.zvonimirkonjevic.intro_to_jetpack_compose.ui.theme.White

@Composable
fun RecipesScreen(
    viewModel: RecipeViewModel,
    navigation: NavController
    ) {
    Column (
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ){
        ScreenTitle(title = "What would you like to cook today?", subtitle = "Good morning, Zvonimir")
        SearchBar(iconResource = R.drawable.ic_search, labelText = "Search...")
        RecipeCategories()
        IconButton(iconResource = R.drawable.ic_plus,  "Add new recipe")
        RecipeList(viewModel = viewModel, navigation = navigation)
    }
}

@Composable
fun ScreenTitle(
    title: String,
    subtitle: String
) {
    Box(
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth()
    ){
        Text(
            text = subtitle,
            style = TextStyle(color = Purple500,
                fontWeight = FontWeight.Light,
                fontStyle = FontStyle.Italic
            ),
            modifier = Modifier
                .padding(horizontal = 15.dp)

        )
        Text(
            text = title,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 26.sp,

                ),
            modifier = Modifier
                .padding(horizontal = 15.dp, vertical = 16.dp)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    @DrawableRes iconResource: Int,
    labelText: String,
    colors: TextFieldColors = TextFieldDefaults.textFieldColors(
        containerColor = Color.Transparent,
        placeholderColor = DarkGray,
        textColor = DarkGray,
        unfocusedLabelColor = DarkGray,
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        disabledIndicatorColor = Color.Transparent
    )
) {
    var searchInput by remember {
        mutableStateOf("")
    }
    TextField(
        value = searchInput,
        onValueChange = { searchInput = it },
        label = {
            Text(labelText)
        },
        leadingIcon = {
            Icon(
                painter = painterResource(id = iconResource),
                contentDescription = labelText,
                tint = DarkGray,
                modifier = Modifier
                    .width(16.dp)
                    .height(16.dp)
            )
        },
        colors = colors,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    )
}

@Composable
fun TabButton(
    text: String,
    isActive: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(24.dp),
        elevation = null,
        colors = if (isActive) ButtonDefaults.buttonColors(contentColor = White, containerColor = Pink) else ButtonDefaults.buttonColors(contentColor = DarkGray, containerColor = LightGray),
        modifier = Modifier
            .fillMaxHeight()
    ) {
        Text(text)
    }
}

@Composable
fun RecipeCategories() {
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
            text = "All",
            isActive = activeButtonId == 0,
            modifier = Modifier.weight(1f)
        ) {
            activeButtonId = 0
        }
        TabButton(
            text = "Breakfast",
            isActive = activeButtonId == 1,
            modifier = Modifier.weight(1f)
        ) {
            activeButtonId = 1
        }
        TabButton(
            text = "Lunch",
            isActive = activeButtonId == 2,
            modifier = Modifier.weight(1f)
        ) {
            activeButtonId = 2
        }
    }
}

@Composable
fun IconButton(
    @DrawableRes iconResource: Int,
    text: String,
    colors: ButtonColors = ButtonDefaults.buttonColors(containerColor =
    Pink),
    side: Int = 0
) {
    Button(
        onClick = { /*TODO*/ },
        colors = colors,
    ) {
        Row {
            if (side == 0) {
                Icon(
                    painter = painterResource(id = iconResource),
                    contentDescription = text
                )
                Spacer(Modifier.width(2.dp))
                Text(
                    text = text,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Light
                    )
                )
            }
            else {
                Text(
                    text = text,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Light
                    )
                )
                Spacer(Modifier.width(2.dp))
                Icon(
                    painter = painterResource(id = iconResource),
                    contentDescription = text
                )
            }
        }
    }
}

@Composable
fun Chip(
    text: String,
    backgroundColor: Color = White,
    textColor: Color = Pink,
) {
    Box(
        modifier = Modifier
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(12.dp)
            )
            .clip(RoundedCornerShape(12.dp))
            .padding(horizontal = 8.dp, vertical = 2.dp)
    ) {
        Text(
            text = text,
            style = TextStyle(
                color = textColor,
                fontSize = 12.sp
            )
        )
    }
}

@Composable
fun RecipeCard(
    imageResource: String,
    title: String,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .padding(bottom = 16.dp)
            .height(326.dp)
            .width(215.dp)
    ) {
        Card(
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = LightGray),
            modifier = Modifier
                .padding(bottom = 8.dp)
                .clickable {
                    onClick()
                }
        ) {
            Box {
                Image(
                    painter = rememberAsyncImagePainter(model =
                    imageResource),
                    contentDescription = title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                )
                Column(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Bottom,
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(16.dp)
                ) {
                    Text(
                        text = title,
                        letterSpacing = 0.32.sp,
                        style = TextStyle(
                            color = White,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                    Row {
                        Chip("30 min")
                        Spacer(Modifier.width(4.dp))
                        Chip("4 ingredients")
                    }
                }
            }
        }
    }
}

@Composable
fun RecipeList(
    viewModel: RecipeViewModel,
    navigation: NavController
) {
    Column {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            Text(
                text = "7 recipes",
                style = TextStyle(color = Color.DarkGray, fontSize =
                14.sp)
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_flame),
                contentDescription = "Flame",
                tint = Color.DarkGray,
                modifier = Modifier
                    .width(18.dp)
                    .height(18.dp)
            )
        }
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            items(viewModel.recipesData.size) {
                RecipeCard(
                    imageResource = viewModel.recipesData[it].image,
                    title = viewModel.recipesData[it].title
                ) {
                    navigation.navigate(
                        Routes.getDetailsPath(it)
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
            }
        }
    }
}