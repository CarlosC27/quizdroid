package edu.uw.ischool.cacs2340142.quizdroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.fragment.*
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.replace
import edu.uw.ischool.cacs2340142.quizdroid.QuizModel

class AnswerPage : Fragment() {

    private val quizViewModel: QuizModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_answer_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val questionText: TextView = view.findViewById(R.id.currentQuestion)
        val correctAnswerText: TextView = view.findViewById(R.id.correctAnswer)
        val myAnswerText: TextView = view.findViewById(R.id.myAnswer)
        val correctAnswerTracker: TextView = view.findViewById(R.id.correctAnswerTracker)
        val nextButton: Button = view.findViewById(R.id.nextQuestion)
        val questionNumberTracker: TextView = view.findViewById(R.id.questionNumberTracker)

        questionNumberTracker.text = "Question ${quizViewModel.currentQuestion + 1} of ${quizViewModel.totalQuestions}"


        val currentQuestion = quizViewModel.getCurrentQuestion()
        questionText.text = currentQuestion?.questionDes
        correctAnswerText.text = "Correct answer: ${currentQuestion?.answer}"
        myAnswerText.text = "Your Answer: ${quizViewModel.myAnswer}"
        correctAnswerTracker.text = "Correct Answers: ${quizViewModel.correctAnswers} out of ${quizViewModel.totalQuestions}"

        nextButton.text = if (quizViewModel.isLastQuestion()) "Finish" else "Next"
        nextButton.setOnClickListener{
            if(quizViewModel.isLastQuestion()){
                parentFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, Homepage()).commit()
            }else{
                quizViewModel.moveToNextQuestion()
                parentFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, QuestionPage()).commit()
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            AnswerPage().apply {
            }
    }
}