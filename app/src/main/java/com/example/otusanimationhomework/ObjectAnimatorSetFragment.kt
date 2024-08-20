package com.example.otusanimationhomework

import android.animation.AnimatorSet
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
import com.example.otusanimationhomework.databinding.FragmentObjectAnimatorSetBinding

class ObjectAnimatorSetFragment : Fragment() {
    private var _binding: FragmentObjectAnimatorSetBinding? = null
    private val binding get() = _binding!!

    companion object {
        private const val DURATION: Long = 3000
        private const val SCALE_TIMES: Float = 3f
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentObjectAnimatorSetBinding.inflate(inflater, container, false)
        val view = binding.root
        val animatorSet = AnimatorSet()
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

        val objectAnimator3 = ObjectAnimator.ofFloat(
            binding.button,
            Button.SCALE_X,
            0f, SCALE_TIMES
        )
            .apply {
                duration = DURATION
                interpolator = BounceInterpolator()
                repeatCount = INFINITE
            }
        val objectAnimator4 = ObjectAnimator.ofFloat(
            binding.button,
            Button.SCALE_Y,
            0f, SCALE_TIMES
        )
            .apply {
                duration = DURATION
                interpolator = BounceInterpolator()
                repeatCount = INFINITE
            }
        animatorSet.apply {
            play(objectAnimator1).before(objectAnimator2)
            play(objectAnimator2).with(objectAnimator3).with(objectAnimator4)
        }
        setValues(animatorSet)
        return view
    }

    private fun setValues(animatorSet: AnimatorSet) {
        binding.header.text = getString(R.string.objectAnimatorSetFragment)
        binding.button.setOnClickListener {
            animatorSet.start()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}