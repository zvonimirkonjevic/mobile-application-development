package hr.ferit.zvonimirkonjevic.intro_to_kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import hr.ferit.zvonimirkonjevic.intro_to_kotlin.ui.theme.Intro_to_kotlinTheme

class intro_to_kotlin : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Variables
        var a = 5 // we can change value
        val b = 10 // similar to constant, we cant change value of it

        var c: Int = 5 // we are telling compiler that variable is of type int

        // DS in Kotlin
        val d: List<Int> = listOf() // list of items
        val e: Map<Int, Int> = mapOf() // key value pairs
        val f: Set<Int> = setOf() // values must be unique
        val g: List<Int>? =
            null // all DS's are nullable - we can add null if we put ? like in this example

        var name: String? =
            null // so key is to put ? in front of variable type when we want to be able to have null values inside of that variable

        var len: Int = name?.length
            ?: 0 // with name? we check if we have something written up in memory or not and if we have just returns null and disregards .length
        // name?.length ?: 0 if is null then print 0

        println("length of my name is: $len") // $len prints out variable value inside of string

        name = "Zvonimir"
        len = name?.length ?: 0

        // Flow Control
        if (len != 0) {
            println("Jej!")
        } else {
            println(":(")
        }

        val cc = if (b == 5) 1 else 2 // shorter written form of if else

        // Loops
        val aa: List<Int> = listOf(1, 2, 3, 4, 5)
        println(aa) // prints out whole list

        for (i in aa) { // similar to foreach in c#
            println(i * 2)
        }

        for (i in 0 until 10) { // similar to python's for i in range
            println(i * 3)
        }

        for (i in 10 downTo 2 step 2) { // similar to for(int i = 10; i>2; i=i+2)
            println(i * 3)
        }

        // Functions
        fun myFirstFunction(repeat: Int) { // if we don't define type that function returns it automatically returns void else after arguments we need to put :{return_type}
            for (i in 0 until repeat) {
                println("Vau Vau!")
            }
        }

        myFirstFunction(5)

        // difference is that in Kotlin we don't have to put this infront of function when calling it inside of class as Kotlin compiler does that for us
    }
}