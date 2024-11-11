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
        val backButton: Button = view.findViewById(R.id.backButtonQuestionPage)

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

        backButton.setOnClickListener {
            if (quizViewModel.isFirstQuestion()) {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, Homepage())
                    .addToBackStack(null)
                    .commit()
            } else {
                quizViewModel.goBackQuestion()
                updateQuestionUI(view)
            }
        }
    }

    private fun updateQuestionUI(view: View) {
        val questionTextView: TextView? = view.findViewById(R.id.currentQuestion)
        val questionNumberTrackerView: TextView? = view.findViewById(R.id.questionNumberTracker)
        val correctAnswerTrackerView: TextView? = view.findViewById(R.id.correctAnswerTracker)
        val answerOptionsGroup: RadioGroup = view.findViewById(R.id.answerOptions)
        val currentQuestion = quizViewModel.currentTopic?.questions?.getOrNull(quizViewModel.currentQuestion)
        questionTextView?.text = currentQuestion?.questionDes ?: ""
        questionNumberTrackerView?.text = "Question ${quizViewModel.currentQuestion + 1} / ${quizViewModel.currentTopic?.numberOfQuestions}"
        correctAnswerTrackerView?.text = "${quizViewModel.correctAnswers} / ${quizViewModel.currentTopic?.numberOfQuestions} Questions Correct"
        answerOptionsGroup.clearCheck()
        currentQuestion?.questionOptions?.forEachIndexed { index, option ->
            val radioButton = answerOptionsGroup.getChildAt(index) as? RadioButton
            radioButton?.text = option
        }
    }



    companion object {

        @JvmStatic
        fun newInstance() =
            QuestionPage().apply {
            }
    }
}