package uz.os3ketchup.composition.domain.repository

import uz.os3ketchup.composition.domain.entity.GameSettings
import uz.os3ketchup.composition.domain.entity.Level
import uz.os3ketchup.composition.domain.entity.Question

interface GameRepository {

    fun generateQuestion(maxSumValue:Int, countOfOptions:Int):Question

    fun getGameSettings(level: Level):GameSettings
}