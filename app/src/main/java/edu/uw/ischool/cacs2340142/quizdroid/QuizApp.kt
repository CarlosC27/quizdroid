package edu.uw.ischool.cacs2340142.quizdroid

import android.app.Application
import android.content.SharedPreferences
import android.util.*
import androidx.preference.PreferenceManager

class QuizApp : Application() {
    lateinit var topicRepository: TopicRepositoryHC
    lateinit var quizViewModel: QuizModel

    override fun onCreate() {
        super.onCreate()
        topicRepository = TopicRepositoryHC(this)
        quizViewModel = QuizModel(topicRepository)
    }
}