package edu.uw.ischool.cacs2340142.quizdroid

import android.content.*
import org.json.*
import java.io.*

class TopicRepositoryHC(private val context: Context) {

    private var topics: List<TopicHC> = emptyList()

    init {
        loadTopicsFromJson()
    }

    private fun loadTopicsFromJson() {
        try {
            val inputStream = context.assets.open("QuizDroidQuestions.json")
            val jsonString = inputStream.bufferedReader().use { it.readText() }

            val jsonArray = JSONArray(jsonString)
            topics = parseTopics(jsonArray)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun parseTopics(jsonArray: JSONArray): List<TopicHC> {
        val topicList = mutableListOf<TopicHC>()

        for (i in 0 until jsonArray.length()) {
            val jsonObject = jsonArray.getJSONObject(i)
            val title = jsonObject.getString("title")
            val desc = jsonObject.getString("desc")
            val questionsArray = jsonObject.getJSONArray("questions")
            val questions = parseQuestions(questionsArray)

            topicList.add(TopicHC(topicTitle = title, topicDescription = desc, questions = questions, imageId = 0)) // imageId is set to 0 as a placeholder
        }
        return topicList
    }

    private fun parseQuestions(questionsArray: JSONArray): List<QuestionHC> {
        val questionList = mutableListOf<QuestionHC>()

        for (j in 0 until questionsArray.length()) {
            val questionObject = questionsArray.getJSONObject(j)
            val text = questionObject.getString("text")
            val correctAnswer = questionObject.getString("answer")
            val answersArray = questionObject.getJSONArray("answers")

            val answers = mutableListOf<String>()
            for (k in 0 until answersArray.length()) {
                answers.add(answersArray.getString(k))
            }

            questionList.add(QuestionHC(questionText = text, correctAnswer = correctAnswer, answers = answers))
        }
        return questionList
    }

    fun getTopics(): List<TopicHC> = topics
}