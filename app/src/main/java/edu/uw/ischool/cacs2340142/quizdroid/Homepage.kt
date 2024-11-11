package edu.uw.ischool.cacs2340142.quizdroid

import android.os.Bundle
import android.view.ContextThemeWrapper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.fragment.app.activityViewModels

class Homepage : Fragment() {

    private val quizViewModel: QuizModel by activityViewModels()

    private val topicRepository: TopicRepository
        get() = (requireActivity().application as QuizApp).topicRepository

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_homepage, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonContainer = view.findViewById<LinearLayout>(R.id.buttonContainer)

        val topics = topicRepository.getTopics()
        for (topic in topics) {
            val topicButton = Button(ContextThemeWrapper(requireContext(), R.style.QuizButtonStyle))
            topicButton.text = topic.topicTitle
            topicButton.setOnClickListener {
                goToTopic(topic.topicTitle)
            }
            buttonContainer.addView(topicButton)
        }
    }

    private fun goToTopic(topicName: String) {
        val fragment = TopicOverveiwPage().apply {
            arguments = Bundle().apply {
                putString("topicName", topicName)
            }
        }
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, fragment)
            .addToBackStack(null)
            .commit()
    }

    companion object {
        @JvmStatic
        fun newInstance() = Homepage()
    }
}
