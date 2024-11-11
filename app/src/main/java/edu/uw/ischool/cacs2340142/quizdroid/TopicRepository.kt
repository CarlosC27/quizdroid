package edu.uw.ischool.cacs2340142.quizdroid

interface TopicRepository {
    fun getTopics(): List<Topic>
    fun getTopic(title: String): Topic?
}