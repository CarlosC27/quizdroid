package edu.uw.ischool.cacs2340142.quizdroid

import android.app.Application
import android.util.*

class QuizApp: Application() {
    val TAG =QuizApp::class.java.canonicalName
    lateinit var topicRepository: TopicRepository

    override fun onCreate() {
        super.onCreate()
        topicRepository = TopicRepositoryHC()
        Log.i(TAG, "Application created")
    }

    override fun onTerminate() {
        super.onTerminate()
        Log.i(TAG, "Application is burning down")
    }
}