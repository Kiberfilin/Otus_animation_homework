package com.example.otusanimationhomework

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.otusanimationhomework.databinding.FragmentValueAnimatorBinding

class ValueAnimatorFragment : Fragment() {
    private var _binding: FragmentValueAnimatorBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentValueAnimatorBinding.inflate(inflater, container, false)
        val view = binding.root
        setValues()
        return view
    }

    private fun setValues() {
        binding.header.text = getString(R.string.valueAnimatorFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}