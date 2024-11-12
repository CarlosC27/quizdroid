package edu.uw.ischool.cacs2340142.quizdroid

data class TopicHC(
    val topicTitle: String,
    val topicDescription: String,
    val questions: List<QuestionHC>,
    val imageId: Int = 0
)
