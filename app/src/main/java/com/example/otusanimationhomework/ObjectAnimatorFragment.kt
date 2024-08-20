package com.example.otusanimationhomework

import android.animation.ObjectAnimator
import android.animation.ValueAnimator.INFINITE
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.BounceInterpolator
import android.widget.Button
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator
import com.example.otusanimationhomework.databinding.FragmentObjectAnimatorBinding

class ObjectAnimatorFragment : Fragment() {
    private var _binding: FragmentObjectAnimatorBinding? = null
    private val binding get() = _binding!!

    companion object {
        private const val DURATION: Long = 3000
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentObjectAnimatorBinding.inflate(inflater, container, false)
        val view = binding.root
        val objectAnimator1 = ObjectAnimator.ofFloat(
            binding.header,
            "alpha",
            1f, 0.2f
        )
            .apply {
                duration = DURATION
                interpolator = LinearOutSlowInInterpolator()
            }
        val objectAnimator2 = ObjectAnimator.ofFloat(
            binding.button,
            Button.TRANSLATION_Z,
            0f, 200f
        )
            .apply {
                duration = DURATION
                interpolator = BounceInterpolator()
                repeatCount = INFINITE
            }
        setValues(objectAnimator1, objectAnimator2)
        return view
    }

    private fun setValues(objectAnimator1: ObjectAnimator, objectAnimator2: ObjectAnimator) {
        binding.header.text = getString(R.string.objectAnimatorFragment)
        binding.button.setOnClickListener {
            objectAnimator1.start()
            objectAnimator2.start()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}