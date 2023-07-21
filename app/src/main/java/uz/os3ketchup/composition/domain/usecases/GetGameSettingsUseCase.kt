package uz.os3ketchup.composition.domain.usecases

import uz.os3ketchup.composition.domain.entity.GameSettings
import uz.os3ketchup.composition.domain.entity.Level
import uz.os3ketchup.composition.domain.repository.GameRepository

class GetGameSettingsUseCase(private val gameRepository:GameRepository) {

    operator fun invoke(level: Level):GameSettings{
        return gameRepository.getGameSettings(level)
    }
}