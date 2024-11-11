package edu.uw.ischool.cacs2340142.quizdroid

data class TopicHC(
    val title: String,
    val shortDescription: String,
    val longDescription: String,
    val questions: List<Question>
)
