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

    private val quizViewModel: QuizModel
        get() = (requireActivity().application as QuizApp).quizViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_homepage, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonContainer = view.findViewById<LinearLayout>(R.id.buttonContainer)
        buttonContainer.removeAllViews()

        val topics = quizViewModel.topicRepository.getTopics()
        for (topic in topics) {
            val topicButton = Button(requireContext()).apply {
                text = topic.topicTitle
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                setOnClickListener {
                    navigateToTopicOverview(topic.topicTitle)
                }
            }
            buttonContainer.addView(topicButton)
        }
    }
    private fun navigateToTopicOverview(topicTitle: String) {
        quizViewModel.setTopic(topicTitle)
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, TopicOverviewPage())
            .addToBackStack(null)
            .commit()
    }

    companion object {
        @JvmStatic
        fun newInstance() = Homepage()
    }
}
