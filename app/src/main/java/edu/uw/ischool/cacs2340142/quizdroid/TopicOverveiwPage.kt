package edu.uw.ischool.cacs2340142.quizdroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import  androidx.fragment.*
import androidx.fragment.app.activityViewModels

class TopicOverveiwPage : Fragment() {

    private val quizViewModel: QuizModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_topic_overveiw_page, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val backButton: Button = view.findViewById(R.id.backButtonQuestionPage)
        val startButton: Button = view.findViewById(R.id.startButton)
        val topicTitle: TextView = view.findViewById(R.id.topicTitle)
        val topicDescription: TextView = view.findViewById(R.id.topicDescription)
        val numberOfQuestions: TextView = view.findViewById(R.id.numberOfQuestions)
        val topicImage: ImageView = view.findViewById(R.id.topicImage)

        val topicName = arguments?.getString("topicName")
        val topic = topicName?.let { currentTopic -> quizViewModel.getTopic(currentTopic) }

        topic?.let { currentTopic ->
            topicTitle.text = currentTopic.topicTitle
            topicImage.setImageResource(currentTopic.imageId)
            topicDescription.text = currentTopic.topicDescription
            numberOfQuestions.text = "Number of questions: ${currentTopic.numberOfQuestions}"

        }

        backButton.setOnClickListener{
            parentFragmentManager.popBackStack()
        }

        startButton.setOnClickListener{
            quizViewModel.setTopic(topicName.toString())
            parentFragmentManager.beginTransaction().replace(R.id.fragmentContainerView, QuestionPage()).addToBackStack(null).commit()

        }


    }


    companion object {
        @JvmStatic
        fun newInstance() =
            TopicOverveiwPage().apply {
            }
    }
}