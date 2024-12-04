package com.example.clientbook.view.cart

import android.os.Bundle
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.clientbook.R
import com.example.clientbook.databinding.FragmentCartBinding


class CartFragment : Fragment() {

    private var _binding: FragmentCartBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.arrowButton.setOnClickListener { view ->
            if (binding.hiddenView.getVisibility() === View.VISIBLE) {
                TransitionManager.beginDelayedTransition(binding.baseCardview, AutoTransition())
                binding.hiddenView.setVisibility(View.GONE)
                binding.arrowButton.setImageResource(R.drawable.ic_down)
            } else {
                TransitionManager.beginDelayedTransition(binding.baseCardview, AutoTransition())
                binding.hiddenView.setVisibility(View.VISIBLE)
                binding.arrowButton.setImageResource(com.example.clientbook.R.drawable.ic_up)
            }
        }
    }
}