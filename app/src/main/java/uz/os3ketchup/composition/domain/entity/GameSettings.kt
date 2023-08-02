package uz.os3ketchup.composition.domain.entity

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GameSettings(
    val maxSumValue:Int,
    val gameTimeInSeconds:Int,
    val minCountRightAnswers:Int,
    val minPercentRightAnswers:Int,
):Parcelable{
    val minPercentRightAnswersString:String
        get() = minPercentRightAnswers.toString()
}