package edu.uw.ischool.cacs2340142.quizdroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import  androidx.fragment.*
import androidx.fragment.app.activityViewModels

class TopicOverviewPage : Fragment() {

    private val quizViewModel: QuizModel
        get() = (requireActivity().application as QuizApp).quizViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_topic_overveiw_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val topicTitle: TextView = view.findViewById(R.id.topicTitle)
        val topicDescription: TextView = view.findViewById(R.id.topicDescription)
        val numberOfQuestions: TextView = view.findViewById(R.id.numberOfQuestions)
        val topicImage: ImageView = view.findViewById(R.id.topicImage)
        val startButton: Button = view.findViewById(R.id.startButton)

        val selectedTopic = quizViewModel.currentTopic
        selectedTopic?.let { topic ->
            topicTitle.text = topic.topicTitle
            topicDescription.text = topic.topicDescription
            numberOfQuestions.text = "${topic.questions.size} Questions"
            topicImage.setImageResource(topic.imageId)
        }

        startButton.setOnClickListener {
            quizViewModel.resetQuizProgress()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, QuestionPage())
                .addToBackStack(null)
                .commit()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = TopicOverviewPage()
    }
}