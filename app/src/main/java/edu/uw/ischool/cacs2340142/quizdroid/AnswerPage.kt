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

    private val quizViewModel: QuizModel
        get() = (requireActivity().application as QuizApp).quizViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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

        val currentQuestion = quizViewModel.getCurrentQuestion()
        questionText.text = currentQuestion?.questionText
        correctAnswerText.text = "Correct answer: ${currentQuestion?.correctAnswer}"
        myAnswerText.text = "Your answer: ${quizViewModel.myAnswer}"
        correctAnswerTracker.text = "Correct answers: ${quizViewModel.correctAnswers} out of ${quizViewModel.totalQuestions}"
        questionNumberTracker.text = "Question ${quizViewModel.currentQuestionIndex + 1} of ${quizViewModel.totalQuestions}"

        nextButton.text = if (quizViewModel.isLastQuestion()) "Finish" else "Next"
        nextButton.setOnClickListener {
            if (quizViewModel.isLastQuestion()) {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, Homepage())
                    .commit()
            } else {
                quizViewModel.moveToNextQuestion()
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, QuestionPage())
                    .addToBackStack(null)
                    .commit()
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = AnswerPage()
    }
}