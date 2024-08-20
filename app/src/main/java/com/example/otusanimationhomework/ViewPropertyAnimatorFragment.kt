package com.example.otusanimationhomework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.BounceInterpolator
import com.example.otusanimationhomework.databinding.FragmentViewPropertyAnimatorBinding

class ViewPropertyAnimatorFragment : Fragment() {
    private var _binding: FragmentViewPropertyAnimatorBinding? = null
    private val binding get() = _binding!!

    companion object {
        private const val DURATION: Long = 3000
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentViewPropertyAnimatorBinding.inflate(inflater, container, false)
        val view = binding.root
        setValues()
        return view
    }

    private fun setValues() {
        binding.header.text = getString(R.string.viewPropertyAnimatorFragment)
        binding.button.setOnClickListener {
            it.animate()
                .translationX(100f)
                .rotationBy(270f).apply {
                    duration = DURATION
                    interpolator = BounceInterpolator()
                }.start()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}