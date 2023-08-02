package uz.os3ketchup.composition.data

import uz.os3ketchup.composition.domain.entity.GameSettings
import uz.os3ketchup.composition.domain.entity.Level
import uz.os3ketchup.composition.domain.entity.Question
import uz.os3ketchup.composition.domain.repository.GameRepository
import java.lang.Integer.max
import java.lang.Integer.min
import java.util.HashSet
import kotlin.random.Random

object GameRepositoryImpl : GameRepository {

    private const val MIN_SUM_VALUE = 2
    private const val MIN_ANSWER_VALUE = 1


    override fun generateQuestion(maxSumValue: Int, countOfOptions: Int): Question {
        val sum = Random.nextInt(MIN_SUM_VALUE, maxSumValue + 1)
        val visibleNumber = Random.nextInt(MIN_ANSWER_VALUE, sum)
        val options = HashSet<Int>()
        val rightAnswer = sum - visibleNumber
        options.add(rightAnswer)
        val from = max(rightAnswer - countOfOptions, MIN_ANSWER_VALUE)
        val to = min(maxSumValue, rightAnswer + countOfOptions)
        while (options.size < countOfOptions) {
            options.add(Random.nextInt(from, to))
        }
        return Question(sum, visibleNumber, options.toList())
    }

    override fun getGameSettings(level: Level): GameSettings {
        return when (level) {
            Level.TEST -> GameSettings(
                10,
                5,
                2,
                75
            )
            Level.EASY -> GameSettings(
                10,
                30,
                3,
                75
            )
            Level.NORMAL -> GameSettings(
                10,
                30,
                5,
                75
            )
            Level.HARD -> GameSettings(
                10,
                30,
                20,
                75
            )



        }
    }
}