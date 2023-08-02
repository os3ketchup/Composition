package uz.os3ketchup.composition.presentation

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import uz.os3ketchup.composition.R
import uz.os3ketchup.composition.domain.entity.GameResult
import uz.os3ketchup.composition.domain.entity.Question

interface OnOptionClickListener{
    fun onOptionClickListener(option:Int){

    }
}

@SuppressLint("StringFormatMatches")
@BindingAdapter("requiredAnswer")
fun bindRequiredAnswers(textView: TextView, count: Int) {
    textView.text = textView.resources.getString(
        R.string.required_score,
        count
    )

}

@SuppressLint("StringFormatMatches")
@BindingAdapter("requiredPercentage")
fun bindRequiredPercentage(textView: TextView, percentage: Int) {
    textView.text = textView.resources.getString(
        R.string.required_percentage, percentage.toString()
    )
}

@SuppressLint("StringFormatMatches")
@BindingAdapter("scoreAnswer")
fun bindScoreAnswer(textView: TextView, count: Int) {
    textView.text = textView.resources.getString(
        R.string.score_answers,
        count
    )
}


@SuppressLint("StringFormatMatches")
@BindingAdapter("scorePercentage")
fun bindScorePercentage(textView: TextView, gameResult: GameResult) {
    textView.text = textView.resources.getString(
        R.string.score_percentage,
        getPercentOfRightAnswers(gameResult)
    )
}

fun getPercentOfRightAnswers(gameResult: GameResult) = with(gameResult) {
    if (countOfQuestions == 0) {
        0
    } else {
        ((countOfRightAnswers / countOfQuestions.toDouble()) * 100).toInt()
    }
}


fun getSmileResId(gameResult: GameResult): Int {
    return if (gameResult.winner) {
        R.drawable.happy_person
    } else {
        R.drawable.sad_person
    }
}

@BindingAdapter("setImage")
fun bindSetImage(imageView: ImageView, gameResult: GameResult) {
    imageView.setImageResource(getSmileResId(gameResult))
}

@BindingAdapter("getColor")
fun bindGetInformation(textView: TextView, enoughCount: Boolean) {
    val color = getColorByState(enoughCount, textView)
    textView.setTextColor(color)
}

fun <T> getColorByState(state: Boolean, view: T): Int {
    val colorResId = if (state) {
        android.R.color.holo_green_light
    } else {
        android.R.color.holo_red_light
    }
    return ContextCompat.getColor((view as View).context, colorResId)

}

@BindingAdapter("getPercent")
fun getPercent(progressBar: ProgressBar, count: Int) {
    progressBar.secondaryProgress = count
}

@BindingAdapter("getEnoughPercent")
fun getEnoughPercent(progressBar: ProgressBar, enough: Boolean) {
    val color = getColorByState(enough, progressBar)
    progressBar.progressTintList = ColorStateList.valueOf(color)
}

@BindingAdapter("getPercentOfRightAnswers")
fun getPercentOfRightAnswers(progressBar: ProgressBar, progress: Int) {
    progressBar.setProgress(progress, true)
}

@BindingAdapter("getNumberAsText")
fun bindNumberAsText(textView: TextView,number: Int) {
    textView.text = number.toString()
}

@BindingAdapter("onOptionClickListener")
fun bindOnOptionClickListener(textView: TextView,onOptionClickListener: OnOptionClickListener){
    textView.setOnClickListener {
        onOptionClickListener.onOptionClickListener(textView.text.toString().toInt())
    }

}







