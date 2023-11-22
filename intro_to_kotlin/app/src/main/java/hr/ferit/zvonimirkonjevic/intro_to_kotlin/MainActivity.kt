package hr.ferit.zvonimirkonjevic.intro_to_kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import hr.ferit.zvonimirkonjevic.intro_to_kotlin.Data.Robot

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var robot = Robot()
        robot.goUp(10)
        robot.goDown(1)
        robot.goRight(6)
        robot.goLeft(1)
        robot.getLocation()
    }
}