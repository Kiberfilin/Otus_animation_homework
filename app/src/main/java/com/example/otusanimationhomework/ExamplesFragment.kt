package com.example.otusanimationhomework

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.makeText
import com.example.otusanimationhomework.databinding.FragmentExamplesListBinding
import com.example.otusanimationhomework.dto.AnimationExample

class ExamplesFragment : Fragment() {

    private var currentToast: Toast? = null
    private var _binding: FragmentExamplesListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentExamplesListBinding.inflate(inflater, container, false)
        val view = binding.root
        with(view) {
            layoutManager = LinearLayoutManager(context)
            adapter = MyExamplesRecyclerViewAdapter(
                AnimationExample.values(),
                ::navigateByAnimationExample
            )
        }
        return view
    }

    private fun navigateByAnimationExample(example: AnimationExample) {
        currentToast?.cancel()
        currentToast = makeText(requireContext(), example.type, Toast.LENGTH_SHORT)
        currentToast?.show()
        when (example) {
            AnimationExample.VALUE_ANIMATOR         -> goToValueAnimatorFragment()
            AnimationExample.OBJECT_ANIMATOR        -> goToObjectAnimatorFragment()
            AnimationExample.OBJECT_ANIMATOR_SET    -> goToObjectAnimatorSetFragment()
            AnimationExample.VIEW_PROPERTY_ANIMATOR -> goToViewPropertyAnimatorFragment()
            else                                    -> throw IllegalArgumentException("Не добавлена обработка enum $example")
        }
    }

    private fun goToViewPropertyAnimatorFragment() {
        (requireActivity() as MainActivity).navController.navigate(R.id.viewPropertyAnimatorFragment)
    }

    private fun goToObjectAnimatorSetFragment() {
        (requireActivity() as MainActivity).navController.navigate(R.id.objectAnimatorSetFragment)
    }

    private fun goToObjectAnimatorFragment() {
        (requireActivity() as MainActivity).navController.navigate(R.id.objectAnimatorFragment)
    }

    private fun goToValueAnimatorFragment() {
        (requireActivity() as MainActivity).navController.navigate(R.id.valueAnimatorFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}