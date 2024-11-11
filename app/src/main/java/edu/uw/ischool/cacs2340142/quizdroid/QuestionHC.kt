package edu.uw.ischool.cacs2340142.quizdroid

data class QuestionHC(
    val questionText: String,
    val answers: List<String>,
    val correctAnswerIndex: Int
)
