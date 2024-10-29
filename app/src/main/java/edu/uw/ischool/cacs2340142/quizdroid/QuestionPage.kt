package edu.uw.ischool.cacs2340142.quizdroid

import android.os.Bundle
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.*
import androidx.fragment.app.activityViewModels
import edu.uw.ischool.cacs2340142.quizdroid.QuizModel


class QuestionPage : Fragment() {

    private val quizViewModel: QuizModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val questionText: TextView = view.findViewById(R.id.currentQuestion)
        val questionNumberTracker: TextView = view.findViewById(R.id.questionNumberTracker)
        val answerOptionsGroup: RadioGroup = view.findViewById(R.id.answerOptions)
        val submitButton: Button = view.findViewById(R.id.submitButton)

        val question = quizViewModel.getCurrentQuestion()
        questionText.text = question?.questionDes
        questionNumberTracker.text = "Question ${quizViewModel.currentQuestion + 1} of ${quizViewModel.totalQuestions}"

        answerOptionsGroup.clearCheck()
        submitButton.isEnabled = false
        question?.questionOptions?.forEachIndexed { index, questionOption ->
            (answerOptionsGroup.getChildAt(index) as RadioButton).text = questionOption
        }

        answerOptionsGroup.setOnCheckedChangeListener { radioGroup, checkedAnswer ->
            submitButton.isEnabled = true
        }

        submitButton.setOnClickListener{
            val selectedAnswerId = answerOptionsGroup.checkedRadioButtonId
            val selectedAnswer = view.findViewById<RadioButton>(selectedAnswerId).text.toString()
            quizViewModel.submitAnswer(selectedAnswer)
            parentFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, AnswerPage()).addToBackStack(null).commit()
        }

    }

    companion object {

        @JvmStatic
        fun newInstance() =
            QuestionPage().apply {
            }
    }
}