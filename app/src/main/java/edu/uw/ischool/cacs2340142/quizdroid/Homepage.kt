package edu.uw.ischool.cacs2340142.quizdroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.*
import androidx.fragment.app.activityViewModels
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.*


class Homepage : Fragment() {

    private val quizViewModel: QuizModel by activityViewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_homepage, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnMath: Button = view.findViewById((R.id.btnMath))
        val btnPhysics: Button = view.findViewById(R.id.btnPhysics)
        val btnMarvel: Button = view.findViewById(R.id.btnMarvelSuperheroes)
        val btnTaylorSwift: Button =view.findViewById(R.id.btnTaylorSwift)
        val btnPokemon: Button = view.findViewById((R.id.btnPokemon))

        btnMath.setOnClickListener{
            goToTopic("Math")
        }
        btnPhysics.setOnClickListener{
            goToTopic("Physics")
        }
        btnMarvel.setOnClickListener{
            goToTopic("Marvel Superheroes")
        }
        btnTaylorSwift.setOnClickListener{
            goToTopic("Taylor Swift")
        }
        btnPokemon.setOnClickListener{
            goToTopic("Pokemon")
        }

    }

    private fun goToTopic(topicName: String){
        val fragment = TopicOverveiwPage()
        fragment.arguments =Bundle().apply{
            putString("topicName", topicName)
        }
        parentFragmentManager.beginTransaction().replace(R.id.fragmentContainerView,fragment).addToBackStack(null).commit()
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            Homepage()
    }
}
