package com.example.otusanimationhomework

import android.animation.ValueAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator
import com.example.otusanimationhomework.databinding.FragmentValueAnimatorBinding

class ValueAnimatorFragment : Fragment() {
    private var _binding: FragmentValueAnimatorBinding? = null
    private val binding get() = _binding!!

    companion object {
        private const val DURATION: Long = 3000
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentValueAnimatorBinding.inflate(inflater, container, false)
        val view = binding.root
        val valueAnimator = ValueAnimator.ofFloat(0f, 360f).apply {
            duration = DURATION
            interpolator = LinearOutSlowInInterpolator()
            addUpdateListener {
                binding.header.apply {
                    rotation = it.animatedValue as Float
                    y += (it.animatedValue as Float) / 30
                }
            }
        }
        setValues(valueAnimator)
        return view
    }

    private fun setValues(valueAnimator: ValueAnimator) {
        binding.header.text = getString(R.string.valueAnimatorFragment)
        binding.button.setOnClickListener {
            valueAnimator.start()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}