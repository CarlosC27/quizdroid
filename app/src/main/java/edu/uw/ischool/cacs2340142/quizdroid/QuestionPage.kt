package edu.uw.ischool.cacs2340142.quizdroid

import android.os.Bundle
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.*
import androidx.fragment.app.activityViewModels
import edu.uw.ischool.cacs2340142.quizdroid.QuizModel


class QuestionPage : Fragment() {

    private val quizViewModel: QuizModel
        get() = (requireActivity().application as QuizApp).quizViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_question_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val questionText: TextView = view.findViewById(R.id.currentQuestion)
        val questionNumberTracker: TextView = view.findViewById(R.id.questionNumberTracker)
        val answerOptionsGroup: RadioGroup = view.findViewById(R.id.answerOptions)
        val submitButton: Button = view.findViewById(R.id.submitButton)
        val backButton: Button = view.findViewById(R.id.backButtonQuestionPage)

        val currentQuestion = quizViewModel.getCurrentQuestion()

        questionText.text = currentQuestion?.questionText
        questionNumberTracker.text = "Question ${quizViewModel.currentQuestionIndex + 1} of ${quizViewModel.totalQuestions}"

        answerOptionsGroup.removeAllViews()
        currentQuestion?.answers?.forEach { option ->
            val radioButton = RadioButton(context).apply {
                text = option
            }
            answerOptionsGroup.addView(radioButton)
        }

        submitButton.isEnabled = false

        answerOptionsGroup.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId != -1) {
                submitButton.isEnabled = true
            }
        }

        submitButton.setOnClickListener {
            val selectedAnswerId = answerOptionsGroup.checkedRadioButtonId
            val selectedAnswer = view.findViewById<RadioButton>(selectedAnswerId).text.toString()
            quizViewModel.submitAnswer(selectedAnswer)

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, AnswerPage())
                .addToBackStack(null)
                .commit()
        }

        backButton.setOnClickListener {
            if (quizViewModel.isFirstQuestion()) {
                parentFragmentManager.popBackStack()
            } else {
                quizViewModel.goBackQuestion()
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, QuestionPage())
                    .addToBackStack(null)
                    .commit()
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = QuestionPage()
    }
}
