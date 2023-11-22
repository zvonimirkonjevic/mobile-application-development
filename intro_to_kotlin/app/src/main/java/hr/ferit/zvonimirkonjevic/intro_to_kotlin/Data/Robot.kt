package hr.ferit.zvonimirkonjevic.intro_to_kotlin.Data

class Robot {
    var x: Int = 0
    var y: Int = 0

    fun goRight(steps: Int){
        x += steps
    }

    fun goLeft(steps: Int){
        x -= steps
    }

    fun goUp(steps: Int){
        y += steps
    }
}