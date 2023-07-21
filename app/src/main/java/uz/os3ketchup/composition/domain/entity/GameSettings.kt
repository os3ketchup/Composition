package uz.os3ketchup.composition.domain.entity

data class GameSettings(
    val maxSumValue:Int,
    val gameTimeInSeconds:Int,
    val minCountRightAnswers:Int,
    val percentRightAnswers:Int,
)