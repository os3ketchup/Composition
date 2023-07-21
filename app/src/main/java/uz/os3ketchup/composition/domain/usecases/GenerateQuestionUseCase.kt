package uz.os3ketchup.composition.domain.usecases

import uz.os3ketchup.composition.domain.entity.Question
import uz.os3ketchup.composition.domain.repository.GameRepository

class GenerateQuestionUseCase(private val gameRepository: GameRepository) {
    operator fun invoke(maxSumValue:Int):Question{
        return gameRepository.generateQuestion(maxSumValue, COUNT_OF_OPTIONS)
    }


    companion object{
        const val COUNT_OF_OPTIONS = 4
    }
}