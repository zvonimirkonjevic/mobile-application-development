package hr.ferit.zvonimirkonjevic.intro_to_jetpack_compose.ui

import android.icu.text.CaseMap
import android.icu.text.CaseMap.Title
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
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
import hr.ferit.zvonimirkonjevic.intro_to_jetpack_compose.R
import hr.ferit.zvonimirkonjevic.intro_to_jetpack_compose.ui.theme.DarkGray
import hr.ferit.zvonimirkonjevic.intro_to_jetpack_compose.ui.theme.LightGray
import hr.ferit.zvonimirkonjevic.intro_to_jetpack_compose.ui.theme.Pink
import hr.ferit.zvonimirkonjevic.intro_to_jetpack_compose.ui.theme.Purple200
import hr.ferit.zvonimirkonjevic.intro_to_jetpack_compose.ui.theme.Purple500
import hr.ferit.zvonimirkonjevic.intro_to_jetpack_compose.ui.theme.White

@Preview(showBackground = true)
@Composable
fun RecipesScreen() {
    
}