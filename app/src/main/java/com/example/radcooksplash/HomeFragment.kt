package com.example.radcooksplash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.radcooksplash.R.*


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(layout.fragment_home, container, false)

        val searchCard = rootView.findViewById<CardView>(R.id.searchCard)
        val forumCard = rootView.findViewById<CardView>(R.id.forumCard)
        val enterrecipeCard = rootView.findViewById<CardView>(R.id.enterrecipeCard)
        val favoritetCard = rootView.findViewById<CardView>(R.id.favoritetCard)
        val enteringredientCard = rootView.findViewById<CardView>(R.id.enteringredientCard)



        searchCard.setOnClickListener {
            val context = requireContext()
            val intent = Intent(context, Search::class.java)
            context.startActivity(intent)
        }





        forumCard.setOnClickListener {
            val context = requireContext()
            val intent = Intent(context, Forum::class.java)
            context.startActivity(intent)
        }
        enterrecipeCard.setOnClickListener {
            val context = requireContext()
            val intent = Intent(context, EnterRecipe::class.java)
            context.startActivity(intent)
        }

        favoritetCard.setOnClickListener {
            val context = requireContext()
            val intent = Intent(context, Favorite::class.java)
            context.startActivity(intent)
        }


        enteringredientCard.setOnClickListener {
            val context = requireContext()
            val intent = Intent(context, Ingredient ::class.java)
            context.startActivity(intent)
        }

        context
        return rootView
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

}